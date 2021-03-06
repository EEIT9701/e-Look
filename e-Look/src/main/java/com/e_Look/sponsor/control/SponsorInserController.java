package com.e_Look.sponsor.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.e_Look.sponsor.model.SponsorService;

@WebServlet("/SponsorInserController")
public class SponsorInserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("132");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession sessionSponsor = request.getSession();
		
		Map sponsorMap=(Map)sessionSponsor.getAttribute("sponsor");
		
		Integer courseID=Integer.parseInt(sponsorMap.get("courseID").toString());
		String SponsorName=sponsorMap.get("SponsorName").toString();
		
		
		Integer money=Integer.parseInt(sponsorMap.get("money").toString());
		
		String addressSpon=sponsorMap.get("addressSpon").toString();
		
		SponsorService sponsorService=new SponsorService();		
		sponsorService.addNameMoney(courseID,SponsorName, money);
		
		response.sendRedirect(addressSpon);
		sessionSponsor.removeAttribute("sponsor");
			
        }

	}


