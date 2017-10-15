package com.e_Look.courseClass;

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

import com.e_Look.eLookEvent.eLookEventDAO_JDBC;
import com.e_Look.eLookEvent.eLookEventVO;
import com.e_Look.member.model.MemberVO;



public class courseClassDAO_JDBC implements courseClass_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/eLookDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_courseClass = "insert into courseClass (ccName,eventID) values (?,?)"; 
	private static final String UPDATE_courseClass = "update courseClass set ccName=? eventID=? where CourseClassID=?"; 
	private static final String DELETE_courseClass = "delete from courseClass where CourseClassID=?"; 
	private static final String SELECT_courseClass = "select CourseClassID,ccName,eventID from BuyCourse where CourseClassID=?";
	private static final String SELECT_event_courseClass = "select CourseClassID,ccName,eventID from BuyCourse where eventID=?";
	private static final String SELECT_ALL_courseClass = "select CourseClassID,ccName,eventID from BuyCourse";
	@Override
	public void insert(courseClassVO courseClassVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(INSERT_courseClass);
			pstmt.setString(1,courseClassVO.getCcName());
			pstmt.setInt(2,courseClassVO.getEventID());//在網頁中selected出eventID
			//討論是否要在insert裡面加入eventID還是在update
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	
	
	@Override
	public void delete(Integer CourseClassID) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(DELETE_courseClass);
			
			pstmt.setInt(1,CourseClassID);
			
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(courseClassVO courseClassVO) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		try {
			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(UPDATE_courseClass);
			
			pstmt.setString(1,courseClassVO.getCcName());
			pstmt.setInt(2,courseClassVO.getEventID());
			
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	
	@Override
	public courseClassVO findByCourseClassID(Integer CourseClassID) {
		courseClassVO courseClassVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_courseClass);
			pstmt.setInt(1, CourseClassID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				courseClassVO = new courseClassVO();
				courseClassVO.setCourseClassID(rs.getInt(1));
				courseClassVO.setCcName(rs.getString(2));
				courseClassVO.setEventID(rs.getInt(3));				
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
		
		return courseClassVO;
	
	}

	public List<courseClassVO> findByEventID(Integer eventID){
			List<courseClassVO> list_event_courseClass = new LinkedList<courseClassVO>();
			Connection conn =null;
			PreparedStatement pstmt=null;
			try {		
				pstmt=conn.prepareStatement(SELECT_event_courseClass);
				pstmt.setInt(1, eventID);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					courseClassVO courseClassVO = new courseClassVO();
					courseClassVO.setCourseClassID(rs.getInt(1));	
					courseClassVO.setCcName(rs.getString(2));	
					courseClassVO.setEventID(rs.getInt(3));	
					list_event_courseClass.add(courseClassVO);
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list_event_courseClass;
	}
			

	@Override
	public List<courseClassVO> getAll() {
		
		List<courseClassVO> list_event_courseClass = new LinkedList<courseClassVO>();
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(SELECT_ALL_courseClass);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				courseClassVO courseClassVO = new courseClassVO();
				courseClassVO.setCourseClassID(rs.getInt(1));	
				courseClassVO.setCcName(rs.getString(2));	
				courseClassVO.setEventID(rs.getInt(3));	
				list_event_courseClass.add(courseClassVO);
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
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list_event_courseClass;
	}

	public static void main(String[] args) {
		//insert一筆資料
		courseClassDAO_JDBC daoJDBC=new courseClassDAO_JDBC();
		
//		eLookEventVO dao = new eLookEventVO();
//		dao.setEventName("萬聖節派對");
//		
//		
//		try {
//			dao.seteStartDate(new Date(System.currentTimeMillis()));
//			dao.seteEndDate(new Date(System.currentTimeMillis()));
//			dao.setePhoto(new FileInputStream(new File("D:/A550/GRD/R0014769.JPG")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		dao.setDiscount(0.8);
//		daoJDBC.insert(dao);
		
		
		//查單筆
//		eLookEventVO list1 = daoJDBC.findByPrimaryKey(1001);
	
//			System.out.print(list1.getEventName()+",");
//			System.out.print(list1.getePhoto()+",");
//			System.out.print(list1.geteStartDate()+",");
//			System.out.print(list1.geteEndDate()+",");
//			System.out.print(list1.getDiscount()+",");
			
		//查全部
//		List<eLookEventVO> list2 = daoJDBC.getAll();
//		for(eLookEventVO eLookEventVO:list2){
//			System.out.print(eLookEventVO.getEventName()+",");
//			System.out.print(eLookEventVO.geteStartDate()+",");
//			System.out.print(eLookEventVO.geteEndDate()+",");
//			System.out.print(eLookEventVO.getDiscount()+",");
//		}
	}
	
	
	
}
