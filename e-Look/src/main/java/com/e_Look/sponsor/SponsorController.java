package com.e_Look.sponsor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SponsorController")
public class SponsorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SponsorName=request.getParameter("SponsorName");
		int money=Integer.parseInt(request.getParameter("money"));
		int courseID=200001;
		
		SponsorService SponsorService=new SponsorService();
		SponsorService.addNameMoney(courseID,SponsorName,money);
		
		
		
		
		
		
		
		
	}

}
