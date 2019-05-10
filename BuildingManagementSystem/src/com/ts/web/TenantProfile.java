package com.ts.web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.LandlordDAO;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Landlords;
import com.ts.dto.Tenants;

@WebServlet("/TenantProfile")
public class TenantProfile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int tenantId = (Integer)session.getAttribute("user");
		
		
		TenantsDAO tenantsDAO = new TenantsDAO();
		Tenants tenants = tenantsDAO.getTenant(tenantId);
		
		request.setAttribute("tenantsData",tenants);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayTenantProfile.jsp");
		rd.include(request, response);

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
