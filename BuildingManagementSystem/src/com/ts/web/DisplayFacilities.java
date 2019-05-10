package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.FacilitiesDAO;
import com.ts.dto.Facilities;


@WebServlet("/DisplayFacilities")
public class DisplayFacilities extends HttpServlet {
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		FacilitiesDAO facilitiesDAO = new FacilitiesDAO();
		List<Facilities> arrayList = facilitiesDAO.getAllFacilities();
		

		request.setAttribute("FacilitiesData", arrayList);
		HttpSession session = request.getSession(false);
		int userId = (int)session.getAttribute("user");
		if(userId == 1234) {
		RequestDispatcher rd = request.getRequestDispatcher("DisplayFacilities.jsp");
		rd.forward(request, response);
		} else  {
			RequestDispatcher rd = request.getRequestDispatcher("FacilitiesAndRegistration.jsp");
			rd.forward(request, response);
		}
   	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
