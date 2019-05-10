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

import com.ts.dao.RoomsDAO;
import com.ts.dto.Rooms;


@WebServlet("/DisplayAllRoomDetails")
public class DisplayAllRoomDetails extends HttpServlet {
	    public DisplayAllRoomDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		RoomsDAO roomsDAO = new RoomsDAO();
		List<Rooms> arrayList = roomsDAO.getAllRooms();

		request.setAttribute("roomsData", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllRoomsDetails.jsp");
		rd.forward(request, response);		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
