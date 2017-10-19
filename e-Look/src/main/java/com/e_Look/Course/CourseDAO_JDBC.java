package com.e_Look.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CourseDAO_JDBC implements CourseDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eLook";
	String userid = "sa";
	//第一組密碼
	//String passwd = "P@ssw0rd";
	//第二組密碼
	String passwd = "123456";
	private static final String INSERT_Course = 
			"insert into Course (courseName,photoName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore,proposalVideopathway) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_Course = 
			"update Course set courseName=?,photoName=?,cPhoto=?,preTool=?,background=?,ability=?,targetgroup=?,soldPrice=?,courseLength=?,targetStudentNumber=?,fundStartDate=?,fundEndDate=?,courseStartDate=?,courseVideopathway=?,paper=?,status=?,courseContent=?,memberID=?,avgScore=?,proposalVideopathway=?";
	private static final String DELETE_Course =
			"delete from Course where courseID= ?";
	private static final String SELECT_ONE_Course =
			"select courseID,courseName,photoName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore,proposalVideopathway from Course where courseID= ?";
	private static final String SELECT_ALL_MEMBER =
			"select courseID,courseName,photoName,cPhoto,preTool,background,ability,targetgroup,soldPrice,courseLength,targetStudentNumber,fundStartDate,fundEndDate,courseStartDate,courseVideopathway,paper,status,courseContent,memberID,avgScore,proposalVideopathway from Course";
	
	@Override
	public void insert(CourseVO courseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_Course);
			pstmt.setString(1, courseVO.getCourseName());
			pstmt.setString(2, courseVO.getPhotoName());
			pstmt.setBlob(3, courseVO.getcPhoto());
			pstmt.setString(4, courseVO.getPreTool());
			pstmt.setString(5, courseVO.getBackground());
			pstmt.setString(6, courseVO.getAbility());
			pstmt.setString(7, courseVO.getTargetgroup());
			pstmt.setInt(8, courseVO.getSoldPrice());
			pstmt.setInt(9, courseVO.getCourseLength());
			pstmt.setInt(10, courseVO.getTargetStudentNumber());
			pstmt.setDate(11, courseVO.getFundStartDate());
			pstmt.setDate(12, courseVO.getFundEndDate());
			pstmt.setDate(13, courseVO.getCourseStartDate());
			pstmt.setString(14, courseVO.getCourseVideopathway());
			pstmt.setBlob(15, courseVO.getPaper());
			pstmt.setInt(16, courseVO.getStatus());			
			pstmt.setString(17, courseVO.getCourseContent());
			pstmt.setInt(18, courseVO.getMemberID());
			pstmt.setDouble(19, courseVO.getAvgScore());
			pstmt.setString(20, courseVO.getProposalVideopathway());
			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "+ e.getMessage());
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
	}







	@Override
	public void update(CourseVO courseVO) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void delete(Integer courseID) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public CourseVO findByPrimaryKey(Integer courseID) {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public List<CourseVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		CourseDAO_JDBC dao = new CourseDAO_JDBC();
		CourseVO CourseVO1 =new CourseVO();
		CourseVO1.setSoldPrice(0);
		CourseVO1.setCourseLength(0);
		CourseVO1.setTargetStudentNumber(0);
		CourseVO1.setStatus(0);
		CourseVO1.setMemberID(100001);
		CourseVO1.setAvgScore(0.0);
		dao.insert(CourseVO1);

	}

}
