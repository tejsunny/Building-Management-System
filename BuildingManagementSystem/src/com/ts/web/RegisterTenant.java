package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.RoomsDAO;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Rooms;
import com.ts.dto.Tenants;

@WebServlet("/RegisterTenant")
public class RegisterTenant extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int flatNo = Integer.parseInt(request.getParameter("flatNo"));
		int tenantId = Integer.parseInt(request.getParameter("Id"));
		String tenantName = request.getParameter("Name");
		String tenantPhNumber = request.getParameter("PhNum");
		String tenantPassword = request.getParameter("psw");
		Tenants tenants = new Tenants(tenantId,tenantName,tenantPhNumber,tenantPassword);
		System.out.println(tenants.getTenantId());
		TenantsDAO tenantsDAO = new TenantsDAO();
		int x = tenantsDAO.register(tenants);
		
		RoomsDAO roomsDAO = new RoomsDAO();
		int y = roomsDAO.update(flatNo,tenants.getTenantId());
		System.out.println("Reached Tenant");
		RequestDispatcher rd = request.getRequestDispatcher("Landlords.jsp");
		rd.include(request, response);
		out.println("<h3><CENTER>Registration Success ......</CENTER></H3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
