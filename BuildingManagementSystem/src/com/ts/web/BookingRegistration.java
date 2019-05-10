package com.ts.web;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BookingsDAO;
import com.ts.dto.Bookings;
import com.ts.dto.Facilities;
import com.ts.dto.Rooms;

@WebServlet("/BookingRegistration")
public class BookingRegistration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		int flatNo = Integer.parseInt(request.getParameter("flatNo"));
		int noOfParticipants = Integer.parseInt(request.getParameter("noOfParticipants"));
		int facilityId = Integer.parseInt(request.getParameter("facilityId"));
		Facilities facilities  = new Facilities();
		facilities.setFacilityId(facilityId);
		Rooms rooms = new Rooms();
		rooms.setFlatNo(flatNo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date today = null;
		try {
			today = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		
	    Bookings booking = new Bookings(facilities, rooms, noOfParticipants,sqlDate);		
		BookingsDAO bookingDao = new BookingsDAO();
		//int x = bookingDao.register(noOfParticipants, facilityId, booking, sqlDate);
		int x = bookingDao.register(booking);
		if(x != 0){
			out.println("<h3><CENTER>Registration Success.........</CENTER></H3>");
		} else{
			out.println("<h3><CENTER>HOUSE FULL.........</CENTER></h3>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("BookingRegistration.jsp");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}