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

import com.ts.dao.RoomsDAO;
import com.ts.dao.TenantsDAO;
import com.ts.dto.Rooms;
import com.ts.dto.Tenants;

@WebServlet("/DisplayTenantBills")
public class DisplayTenantBills extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int tenantId = (int)session.getAttribute("user");
		RoomsDAO roomdao = new RoomsDAO();
		Rooms room = roomdao.getRoomByTenantId(tenantId);
		request.setAttribute("roomData", room);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayTenantBills.jsp");
		rd.include(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
