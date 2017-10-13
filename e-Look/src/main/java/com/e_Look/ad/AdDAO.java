package com.e_Look.ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdDAO implements AdDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_Ad =
			"INSERT INTO Ad (fileName, adFile, status) VALUES (?,?,?) ";
	private static final String UPDATE_Ad =
			"UPDATE Ad SET fileName=?, adFile=?, status=? WHERE adID=?";
//	private static final String UPDATE_STATUS =
//		    "UPDATE Ad SET status=? WHERE adID=?";
	private static final String DELETE_Ad =
		    "DELETE FROM Ad WHERE adID =?";
	private static final String SELECT_ONE_Ad =
			"SELECT adID, fileName, adFile, status FROM Ad WHERE adID=?";
	private static final String SELECT_ALL_Ad =
			"SELECT adID, fileName, adFile, status FROM Ad";
	
	@Override
	public void insert(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_Ad);
			pstmt.setString(1, adVO.getFileName());
			pstmt.setBlob(2, adVO.getAdFile());
			pstmt.setByte(3, adVO.getStatus());
			pstmt.executeUpdate();
			
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void update(AdVO adVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE Ad SET fileName=?, adFile=?, status=? WHERE adID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_Ad);
			pstmt.setString(1, adVO.getFileName());
			pstmt.setBlob(2, adVO.getAdFile());
			pstmt.setByte(3, adVO.getStatus());
			pstmt.setInt(4, adVO.getAdID());
			pstmt.executeUpdate();
		
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer adID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM Ad WHERE adID =?";
			con = ds.getConnection();
			pstmt=con.prepareStatement(DELETE_Ad);
			pstmt.setInt(1, adID);
			pstmt.executeUpdate();
			
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public AdVO findByAdID(Integer adID) {
		AdVO adVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//"SELECT adID, fileName, adFile, status FROM Ad WHERE adID=?";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_Ad);
			pstmt.setInt(1, adID);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// adVO 也稱為 Domain objects
				adVO = new AdVO();
				adVO.setAdID(rs.getInt("adID"));
				adVO.setFileName(rs.getString("fileName"));
				adVO.setAdFile(rs.getBinaryStream("adFile"));
				adVO.setStatus(rs.getByte("status"));
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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
		return adVO;
	}

	@Override
	public List<AdVO> getAll() {
		List<AdVO> list = new ArrayList<AdVO>();
		AdVO adVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			//"SELECT adID, fileName, adFile, status FROM Ad";
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_Ad);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// adVO 也稱為 Domain objects
				adVO = new AdVO();
				adVO.setAdID(rs.getInt("adID"));
				adVO.setFileName(rs.getString("fileName"));
				adVO.setAdFile(rs.getBinaryStream("adFile"));
				adVO.setStatus(rs.getByte("status"));
				list.add(adVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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
