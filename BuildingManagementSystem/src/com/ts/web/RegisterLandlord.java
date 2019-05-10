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
import com.ts.dao.RoomsDAO;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Landlords;
import com.ts.dto.Rooms;
import com.ts.dto.Tenants;

@WebServlet("/RegisterLandlord")
public class RegisterLandlord extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int flatNo = Integer.parseInt(request.getParameter("flatNo"));
		int landlordId = Integer.parseInt(request.getParameter("landlordId"));
		String landlordName = request.getParameter("landlordName");
		String landlordPhNumber = request.getParameter("landlordPhNumber");
		String landlordPassword = request.getParameter("landlordPassword");
		Landlords landlords = new Landlords(landlordId,landlordName,landlordPhNumber,landlordPassword);
		LandlordDAO LandlordsDAO = new LandlordDAO();
		int x = LandlordsDAO.register(landlords);
		
		RoomsDAO roomsDAO = new RoomsDAO();
		int y = roomsDAO.updateLandlord(flatNo,landlords.getLandlordId());
		RequestDispatcher rd = request.getRequestDispatcher("Owner.jsp");
		rd.include(request, response);
		out.println("<h3><CENTER>Registration Success .."+x+" Rows inserted...</CENTER></H3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
