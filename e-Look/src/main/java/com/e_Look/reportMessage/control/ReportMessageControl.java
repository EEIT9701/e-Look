package com.e_Look.reportMessage.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_Look.reportMessage.model.ReportMessageService;

/**
 * Servlet implementation class ReportMessageControl
 */
@WebServlet("/backstage/ReportMessageControl")
public class ReportMessageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//用來到時使用out.println()把JSON格式輸出到網頁上
		PrintWriter out = response.getWriter();

		/***************************1.接收請求參數****************************************/
		int status = new Integer(request.getParameter("status"));
		if(status == 1){
			
		}
		Integer reportID=null;
		/***************************2.開始查詢資料*****************************************/
		//獲得點擊"遮蔽留言"或"不處理"所傳來的對應reportID
		String reportIDSTR = request.getParameter("reportIDx");
		if(status == 1){
			if(reportIDSTR != null){
				reportID = Integer.parseInt(reportIDSTR);
				//使用Service並傳入對應的reportID以及對 Message欄位所做出的判斷status
				ReportMessageService rmServ = new ReportMessageService();
				rmServ.hideMessage(reportID,status);
			}
		}else if(status == 2){
			if(reportIDSTR != null){
				reportID = Integer.parseInt(reportIDSTR);
				//使用Service並傳入對應的reportID以及對 Message欄位所做出的判斷status
				ReportMessageService rmServ = new ReportMessageService();
				rmServ.judeMessage(reportID,status);
			}
		}

		
		//使用Service,取出資料庫包裝好的JSON資料並輸出
		ReportMessageService rmService = new ReportMessageService();
		String jsonObj = rmService.getJSON(status);
		out.println(jsonObj);
	}

}
