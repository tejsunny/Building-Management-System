package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.FacilitiesDAO;
import com.ts.dao.RoomsDAO;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Facilities;
import com.ts.dto.Tenants;

@WebServlet("/AddFacility")
public class AddFacility extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int facilityId = Integer.parseInt(request.getParameter("facilityId"));
		String facilityName = request.getParameter("facilityName");
		int limitedPeople = Integer.parseInt(request.getParameter("limitedPeople"));
		Facilities facilities = new Facilities(facilityId,facilityName,limitedPeople);
		FacilitiesDAO facilitiessDAO = new FacilitiesDAO();
		int x = facilitiessDAO.register(facilities);
		RequestDispatcher rd = request.getRequestDispatcher("Owner.jsp");
		rd.include(request, response);
		out.println("<h3><CENTER>Facility Added Successfully ..</CENTER></H3>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
