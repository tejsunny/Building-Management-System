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

@WebServlet("/EditLandlordProfile")
public class EditLandlordProfile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Edit");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int landlordId = Integer.parseInt(request.getParameter("landlordId"));	
		System.out.println("Servlet");
		LandlordDAO landlordsDao = new LandlordDAO();
		Landlords landlords = landlordsDao.getLandlords(landlordId);
		if(landlords!=null){
			request.setAttribute("landlords", landlords);
			RequestDispatcher rd2 = request.getRequestDispatcher("EditLandlord.jsp");
			rd2.include(request, response);
		}
		else{
			out.println("Landlord not found");
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
