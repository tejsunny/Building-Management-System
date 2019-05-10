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
import com.ts.dto.Rooms;

@WebServlet("/getRoomsDetailsByFloorNo")
public class getRoomsDetailsByFloorNo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int floor = Integer.parseInt(request.getParameter("fid"));
		
		
		RoomsDAO roomsDAO = new RoomsDAO();
		List<Rooms> rooms = roomsDAO.getRoomsById(floor);
		request.setAttribute("roomsData", rooms);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllRoomsByFloorNo.jsp");
		rd.include(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
