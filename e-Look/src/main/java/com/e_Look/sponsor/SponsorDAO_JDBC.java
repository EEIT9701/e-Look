package com.e_Look.sponsor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAO_JDBC implements SponsorDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=elook";
	String userid = "sa";
	//第一組密碼
	String passwd = "P@ssw0rd";
	//第二組密碼
	//String passwd = "123456";
	
	private static final String INSERT_SPONSOR =
			"INSERT INTO Sponsor (courseID, SponsorName, money) VALUES (?,?,?) ";
	//寫著,但應該用不到
	private static final String UPDATE_SPONSOR =
			"UPDATE Sponsor SET SponsorName=?, money=? WHERE courseID=?";
	//寫著,但應該用不到
	private static final String DELETE_SPONSOR =
		    "DELETE FROM Sponsor WHERE courseID =?";
	private static final String SELECT_ONE_SPONSOR =
			"SELECT courseID, SponsorName, money FROM Sponsor WHERE courseID=?";
	private static final String SELECT_ALL_SPONSOR =
			"SELECT courseID, SponsorName, money FROM Sponsor";

	@Override
	public void insert(SponsorVO sponsorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_SPONSOR);
			pstmt.setInt(1, sponsorVO.getCourseID());
			pstmt.setString(2, sponsorVO.getSponsorName());
			pstmt.setInt(3, sponsorVO.getMoney());
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void update(SponsorVO sponsorVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"UPDATE Sponsor SET SponsorName=?, money=? WHERE courseID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_SPONSOR);
			pstmt.setInt(1, sponsorVO.getCourseID());
			pstmt.setString(2, sponsorVO.getSponsorName());
			pstmt.setInt(3, sponsorVO.getMoney());
			pstmt.executeUpdate();
		
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(Integer courseID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//"DELETE FROM Sponsor WHERE courseID =?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt=con.prepareStatement(DELETE_SPONSOR);
			pstmt.setInt(1, courseID);
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public SponsorVO findByCourseID(Integer courseID) {
		SponsorVO sponsorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//"SELECT courseID, SponsorName, money FROM Sponsor WHERE courseID=?";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ONE_SPONSOR);

			pstmt.setInt(1, courseID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// sponsorVO 也稱為 Domain objects
				sponsorVO = new SponsorVO();
				sponsorVO.setCourseID(rs.getInt("courseID"));
				sponsorVO.setSponsorName(rs.getString("sponsorName"));
				sponsorVO.setMoney(rs.getInt("money"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return sponsorVO;
	}

	@Override
	public List<SponsorVO> getAll() {
		List<SponsorVO> list = new ArrayList<SponsorVO>();
		SponsorVO sponsorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//"SELECT courseID, SponsorName, money FROM Sponsor";
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_ALL_SPONSOR);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// sponsorVO 也稱為 Domain objects
				sponsorVO = new SponsorVO();
				sponsorVO.setCourseID(rs.getInt("courseID"));
				sponsorVO.setSponsorName(rs.getString("sponsorName"));
				sponsorVO.setMoney(rs.getInt("money"));
				list.add(sponsorVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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

	public static void main(String[] args) {
		
		SponsorDAO_JDBC dao = new SponsorDAO_JDBC();
		
		// 新增
		SponsorVO sponsorVO1 = new SponsorVO();
		sponsorVO1.setCourseID(200001);
		sponsorVO1.setSponsorName("王大明");
		sponsorVO1.setMoney(1000);
		dao.insert(sponsorVO1);
		
		//修改
//		SponsorVO sponsorVO2 = new SponsorVO();
//		sponsorVO1.setCourseID(200001);
//		sponsorVO1.setSponsorName("王大明");
//		sponsorVO1.setMoney(500);
//		dao.update(sponsorVO2);
		
		//刪除
//		dao.delete(200001);
		
		//查詢單一
		SponsorVO sponsorVO3 = dao.findByCourseID(200001);
		System.out.println(sponsorVO3.getCourseID());
		System.out.println(sponsorVO3.getSponsorName());
		System.out.println(sponsorVO3.getMoney());
		System.out.println("---------------------------");
		
		//查詢全部
		List<SponsorVO> list = dao.getAll();
		for(SponsorVO sponsorVO : list){
			System.out.print(sponsorVO.getCourseID() + "  ");
			System.out.print(sponsorVO.getSponsorName() + "  ");
			System.out.print(sponsorVO.getMoney());
		}
	}

}
