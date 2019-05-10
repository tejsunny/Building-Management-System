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
//import com.ts.dao.EmployeeDAO;
//import com.ts.dto.Employee;
import com.ts.dto.Landlords;
import com.ts.dto.Tenants;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int user = Integer.parseInt(request.getParameter("uid"));
			String pass = request.getParameter("pwd");
			System.out.println("pass"+pass);
			
			String check=request.getParameter("person");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			session.setAttribute("pass", pass);
			if(user==1234 && pass.equals("1234")){
				RequestDispatcher rd = request.getRequestDispatcher("Owner.jsp");
				rd.forward(request, response);
			}
			else if(check.equals("landlord")) {
				LandlordDAO landLordsDao = new LandlordDAO();
				Landlords landlords = landLordsDao.getLandlords(user);
				if(landlords.getLandlordId()==user && landlords.getLandlordPassword().equals(pass)){
				RequestDispatcher rd = request.getRequestDispatcher("Landlords.jsp");
				rd.forward(request, response);
				}
				else{
					out.print("<body>");
					out.print("<center><h2>Invalid Credentials..</h2></center>");
					out.print("<center><h3>TRY AGAIN!!!</h3></center>");
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.include(request, response);
					out.print("</body>");			
				}

			}
			else if(check.equals("tenant")) {
				TenantsDAO tenantsDao = new TenantsDAO();
				Tenants tenants = tenantsDao.getTenant(user);
				if(tenants.getTenantId()==user && tenants.getTenantPassword().equals(pass)){
					RequestDispatcher rd = request.getRequestDispatcher("Tenants.jsp");
					rd.forward(request, response);
				} 	
				else{
					out.print("<body>");
					out.print("<center><h2>Invalid Credentials..</h2></center>");
					out.print("<center><h3>TRY AGAIN!!!</h3></center>");
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.include(request, response);
					out.print("</body>");			
				}

			}
			else{
				out.print("<body>");
				out.print("<center><h2>Invalid Credentials..</h2></center>");
				out.print("<center><h3>TRY AGAIN!!!</h3></center>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				out.print("</body>");			
			}

				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
