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

@WebServlet("/FlatsForSaleServlet")
public class FlatsForSaleServlet extends HttpServlet {

  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		RoomsDAO roomsDAO = new RoomsDAO();
		List<Rooms> arrayList = roomsDAO.getAllFlatsForSale();
		request.setAttribute("flatsForSale", arrayList);
		/*LandlordDAO landlordDAO = new LandlordDAO();
		List<Landlords> arrayList1 = landlordDAO.getAllLandlords();
		request.setAttribute("landlords", arrayList1);*/
		RequestDispatcher rd = request.getRequestDispatcher("FlatsForSale.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
