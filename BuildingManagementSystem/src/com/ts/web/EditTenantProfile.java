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

/**
 * Servlet implementation class EditTenantProfile
 */
@WebServlet("/EditTenantProfile")
public class EditTenantProfile extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("In Edit");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int tenantId = Integer.parseInt(request.getParameter("tenantId"));	
			TenantsDAO tenantsDao = new TenantsDAO();
			Tenants tenants = tenantsDao.getTenant(tenantId);
			if(tenants!=null){
				request.setAttribute("tenants", tenants);
				RequestDispatcher rd2 = request.getRequestDispatcher("EditTenant.jsp");
				rd2.include(request, response);
			}
			else{
				out.println("Tenant not found");
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
