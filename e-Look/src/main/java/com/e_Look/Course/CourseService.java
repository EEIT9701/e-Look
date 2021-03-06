package com.e_Look.Course;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.Part;

import com.e_Look.member.model.MemberVO;

public class CourseService {
	private CourseDAO_interface dao;
	public CourseService() {
		dao = new CourseDAO();
	}
	public Integer CreateNewCourse(Integer memberID) {
		CourseVO CourseVO1 = new CourseVO();
		CourseVO1.setSoldPrice(0);
		CourseVO1.setCourseLength(0);
		CourseVO1.setTargetStudentNumber(0);
		CourseVO1.setStatus(0);
		CourseVO1.setMemberID(memberID);
		CourseVO1.setAvgScore(0.0);
		Integer CourseID = dao.insert(CourseVO1);
		return CourseID;
	}
	public void updateCourseContent(CourseVO courseVO) {
		dao.update(courseVO);
	}
	public void updateCourseVideoPathway(CourseVO courseVO) {
		dao.updatecourseVideopathway(courseVO);
	}
	public void updateCourseImage(Integer CourseID, Part part) {

		if (part.getSize() > 0) {
			CourseVO courseVO2 = new CourseVO();
			courseVO2.setCourseID(CourseID);
			try {
				courseVO2.setcPhoto(part.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.updateimage(courseVO2);
		}

	}
	public CourseVO getCourse(Integer courseID){
		
		return dao.findByPrimaryKey(courseID);
		
	}
	public void updateCoursePaper(Integer CourseID, Part part) {

		if (part.getSize() > 0) {
			CourseVO courseVO3 = new CourseVO();
			courseVO3.setCourseID(CourseID);
			try {
				courseVO3.setPaper(part.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.updatepaper(courseVO3);
		}

	}
	public CourseVO getCourseData(Integer courseID) {
		return dao.findByPrimaryKey(courseID);
		
	}
	public void deleteCourse(Integer courseID) {

			dao.delete(courseID);
		
	}

}
