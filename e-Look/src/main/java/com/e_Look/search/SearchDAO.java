package com.e_Look.search;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SearchDAO implements SearchDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_SEARCH = "insert into Search (keyWord,enterTime) values (?,getdate())";
	// deprecated
	private static final String UPDATE_SEARCH = "update Search set keyWord=? , enterTime=? where keyWord=? and enterTime=?";
	private static final String DELETE_SEARCH = "delete from Search where keyWord=? and enterTime=?";
	private static final String DELETE_DATE_SEARCH = "delete from Search where enterTime < ?";
	private static final String SELECT_SEARCH_RANK = "select keyWord, count(*) as keywordcount from Search group by keyword order by keywordcount desc";
	private static final String SELECT_ALL_SEARCH = "select keyWord,enterTime from Search";

	@Override
	public void insert(SearchVO searchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_SEARCH);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(SearchVO oldSearchVO, SearchVO newSearchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_SEARCH);
			pstmt.setString(1, oldSearchVO.getKeyWord());
			pstmt.setDate(2, oldSearchVO.getEnterTime());
			pstmt.setString(3, newSearchVO.getKeyWord());
			pstmt.setDate(4, newSearchVO.getEnterTime());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(SearchVO searchVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_SEARCH);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setDate(2, searchVO.getEnterTime());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void dateDelete(Date date) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_DATE_SEARCH);
			pstmt.setDate(1, date);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public List<SearchVO> getKeywordRank(Integer i) {
		List<SearchVO> list = new ArrayList<SearchVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_SEARCH_RANK);
			ResultSet rs = pstmt.executeQuery();
			Integer i2 =1;
			while (rs.next() && i2<=i) {
				SearchVO searchVO = new SearchVO(); 
				searchVO.setKeyWord(rs.getString("keyword"));
				list.add(searchVO);
				i2++;
			}
			

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<SearchVO> getAll() {
		List<SearchVO> list = new ArrayList<SearchVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_SEARCH);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				SearchVO searchVO=new SearchVO();
				searchVO.setKeyWord(rs.getString("keyWord"));
				searchVO.setEnterTime(rs.getDate("enterTime"));
				list.add(searchVO);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}


}
