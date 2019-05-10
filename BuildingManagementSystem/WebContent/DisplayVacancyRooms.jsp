<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,com.ts.dto.Rooms" import="java.util.ArrayList,com.ts.dto.Tenants"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 80%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 20px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body>
    <h1><center><b>RENT A FLAT FIND A HOME</b></center></h1>

	<table border=2 align=center>
		<tr>
			<th>ROOMNO</th>
			<th>ROOM_TYPE</th>
			<th>FLOOR</th>
			<th>LAND_LORD_NAME</th>
			<th>LAND_LORD_PHNUMBER</th>
		</tr>
		<c:forEach var="room" items="${vacancyRoomsData}">
	    <tr>	
				<td>${room.flatNo}</td>
				<td>${room.flatType}</td>
				<td>${room.floor}</td>
				<td>${room.landlords.landlordName}</td>
				<td>${room.landlords.landlordPhNumber}</td>  
		</tr>
		</c:forEach>
	</table>


</body>
</html>