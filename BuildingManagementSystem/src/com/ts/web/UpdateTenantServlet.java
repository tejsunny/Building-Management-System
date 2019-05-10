package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Tenants;

@WebServlet("/UpdateTenantServlet")
public class UpdateTenantServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int tenantId = Integer.parseInt(request.getParameter("tenantId"));
			String tenantName = request.getParameter("tenantName");
			String tenantPhNumber = request.getParameter("tenantPhNumber");
			String tenantPassword = request.getParameter("tenantPassword");
			Tenants tenants = new  Tenants(tenantId,tenantName,tenantPhNumber, tenantPassword);
			TenantsDAO tenantsDao = new TenantsDAO();
			int x = tenantsDao.updateDao(tenants);
			out.println("<html>");
			System.out.println("Updated Successfully........");
			RequestDispatcher rd = request.getRequestDispatcher("Tenants.jsp");
			rd.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
