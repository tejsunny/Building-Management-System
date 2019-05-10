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

import com.ts.dao.LandlordDAO;
import com.ts.dto.Landlords;

@WebServlet("/DisplayAllLandlordDetails")
public class DisplayAllLandlordDetails extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
			LandlordDAO landlordsDAO = new LandlordDAO();
			List<Landlords> arrayList = landlordsDAO.getAllLandlords();

			request.setAttribute("landlordsData", arrayList);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayAllLandlordDetails.jsp");
			rd.forward(request, response);		

		
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
