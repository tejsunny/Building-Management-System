package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BillsDAO;
import com.ts.dao.RoomsDAO;

@WebServlet("/DeleteTenantServlet")
public class DeleteTenantServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//int tenantId = Integer.parseInt(request.getParameter("tenantId"));
		int flatNo = Integer.parseInt(request.getParameter("flatNo"));
		RoomsDAO roomsDAO = new RoomsDAO();
		int x  = roomsDAO.deleteTenant(flatNo);
		BillsDAO billsDAO = new BillsDAO();
		int y = billsDAO.updateBills(flatNo);

		out.println("<html>");
		if(x > 0){
			out.println("<h3><CENTER>FLAT IS VACANT...</CENTER></H3>");
            RequestDispatcher rd = request.getRequestDispatcher("Landlords.jsp");
			rd.include(request, response);
		}
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
