package com.e_Look.ReportCourse.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportCourseInsert")
public class ReportCourseInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReportCourseInsert() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer memberID= Integer.valueOf(request.getParameter("memberID"));
		Integer courseID= Integer.valueOf(request.getParameter("courseID"));
		
		
	}

}