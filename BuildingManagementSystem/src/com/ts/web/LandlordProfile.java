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

import com.ts.dao.LandlordDAO;
import com.ts.dao.RoomsDAO;
import com.ts.dto.Landlords;
import com.ts.dto.Rooms;


@WebServlet("/LandlordProfile")
public class LandlordProfile extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("In LandLord");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(false);
			int landlordId = (Integer)session.getAttribute("user");
			
			
			LandlordDAO landlordsDAO = new LandlordDAO();
			Landlords landlords = landlordsDAO.getLandlords(landlordId);
			
			request.setAttribute("landlordsData",landlords);
			
			RequestDispatcher rd = request.getRequestDispatcher("DisplayLandlordProfile.jsp");
			rd.include(request, response);

			
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
