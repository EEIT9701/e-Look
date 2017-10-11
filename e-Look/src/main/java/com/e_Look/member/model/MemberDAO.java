package com.e_Look.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO implements MemberDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_MEMBER = "insert into Member ( email,mPassword,mName,mPhoto,skill,hobby,registerDate,status,count,address) values ( ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
	private static final String UPDATE_MEMBER = "update Member set email=?, mPassword=?, mName=?, skill=?, hobby=?, address=? where memberID= ?";
	private static final String UPDATE_STATUS = "update Member set status=? where memberID= ?";
	private static final String UPDATE_COUNT = "update Member set count=? where memberID= ?";
	private static final String DELETE_MEMBER = "delete from Member where memberID= ?";
	private static final String SELECT_ONE_MEMBER = "select memberID ,email,mPassword,mName,mPhoto,skill,hobby,registerDate,status,count,address from Member where memberID= ?";
	private static final String SELECT_ALL_MEMBER = "select memberID ,email,mPassword,mName,mPhoto,skill,hobby,registerDate,status,count,address from Member";
	private static final String SELECT_EMAIL_MEMBER =
		      "select memberID ,email,mPassword,mName,mPhoto,skill,hobby,registerDate,status,count,address from Member where email= ?";
	@Override
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_MEMBER);
			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getmPassword());
			pstmt.setString(3, memberVO.getmName());
			pstmt.setBlob(4, memberVO.getmPhoto());
			pstmt.setString(5, memberVO.getSkill());
			pstmt.setString(6, memberVO.getHobby());
			pstmt.setDate(7, memberVO.getRegisterDate());
			pstmt.setByte(8, memberVO.getStatus());
			pstmt.setInt(9, memberVO.getCount());
			pstmt.setString(10, memberVO.getAddress());
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
	public void update(MemberVO memberVO, String update) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			if (update.equalsIgnoreCase("member")) {
				pstmt = con.prepareStatement(UPDATE_MEMBER);
				pstmt.setString(1, memberVO.getEmail());
				pstmt.setString(2, memberVO.getmPassword());
				pstmt.setString(3, memberVO.getmName());
			//	pstmt.setBlob(4, memberVO.getmPhoto());
				pstmt.setString(4, memberVO.getSkill());
				pstmt.setString(5, memberVO.getHobby());
				pstmt.setString(6, memberVO.getAddress());
				pstmt.setInt(7, memberVO.getMemberID());
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("status")) {
				pstmt = con.prepareStatement(UPDATE_STATUS);
				pstmt.setByte(1, memberVO.getStatus());
				pstmt.setInt(2, memberVO.getMemberID());
				pstmt.executeUpdate();
			} else if (update.equalsIgnoreCase("count")) {
				pstmt = con.prepareStatement(UPDATE_COUNT);
				pstmt.setInt(1, memberVO.getCount());
				pstmt.setInt(2, memberVO.getMemberID());
				pstmt.executeUpdate();
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
	}

	@Override
	public void delete(Integer memberID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_MEMBER);
			pstmt.setInt(1, memberID);
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
	public MemberVO findByPrimaryKey(Integer memberID) {
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE_MEMBER);
			pstmt.setInt(1, memberID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberID(rs.getInt(1));
				memberVO.setEmail(rs.getString(2));
				memberVO.setmPassword(rs.getString(3));
				memberVO.setmName(rs.getString(4));
				memberVO.setmPhoto(rs.getBinaryStream(5));
				memberVO.setSkill(rs.getString(6));
				memberVO.setHobby(rs.getString(7));
				memberVO.setRegisterDate(rs.getDate(8));
				memberVO.setStatus(rs.getByte(9));
				memberVO.setCount(rs.getInt(10));
				memberVO.setAddress(rs.getString(11));
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
		return memberVO;
	}
	@Override
	public MemberVO findByPrimaryKey(String email) {
		MemberVO memberVO=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_EMAIL_MEMBER);
			pstmt.setString(1, email);
			ResultSet  rs=pstmt.executeQuery();
			if(rs.next()){
				memberVO=new MemberVO();
				memberVO.setMemberID(rs.getInt(1));
				memberVO.setEmail(rs.getString(2));
				memberVO.setmPassword(rs.getString(3));
				memberVO.setmName(rs.getString(4));
				memberVO.setmPhoto(rs.getBinaryStream(5));
				memberVO.setSkill(rs.getString(6));
				memberVO.setHobby(rs.getString(7));
				memberVO.setRegisterDate(rs.getDate(8));
				memberVO.setStatus(rs.getByte(9));
				memberVO.setCount(rs.getInt(10));
				memberVO.setAddress(rs.getString(11));
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. "
					+ e.getMessage());
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
		return memberVO;
	}
	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new LinkedList<MemberVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL_MEMBER);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setMemberID(rs.getInt(1));
				memberVO.setEmail(rs.getString(2));
				memberVO.setmPassword(rs.getString(3));
				memberVO.setmName(rs.getString(4));
				memberVO.setmPhoto(rs.getBinaryStream(5));
				memberVO.setSkill(rs.getString(6));
				memberVO.setHobby(rs.getString(7));
				memberVO.setRegisterDate(rs.getDate(8));
				memberVO.setStatus(rs.getByte(9));
				memberVO.setCount(rs.getInt(10));
				memberVO.setAddress(rs.getString(11));
				list.add(memberVO);
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
