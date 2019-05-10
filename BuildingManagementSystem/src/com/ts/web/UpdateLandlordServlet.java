package com.ts.web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.LandlordDAO;
import com.ts.dto.Landlords;

@WebServlet("/UpdateLandlordServlet")
public class UpdateLandlordServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int landlordId = Integer.parseInt(request.getParameter("landlordId"));
			String landlordName = request.getParameter("landlordName");
			String landlordPhNumber = request.getParameter("landlordPhNumber");
			String landlordPassword = request.getParameter("landlordPassword");
			Landlords landlords = new  Landlords(landlordId,landlordName,landlordPhNumber, landlordPassword);
			LandlordDAO landlordsDao = new LandlordDAO();
			int x = landlordsDao.updateDao(landlords);
			out.println("<html>");
			request.setAttribute("landlordsData", landlords);
			System.out.println("Updated Successfully........");
			RequestDispatcher rd = request.getRequestDispatcher("Landlords.jsp");
			rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
