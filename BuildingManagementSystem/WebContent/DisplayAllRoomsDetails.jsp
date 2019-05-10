<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<jsp:include page="Owner.jsp" />
<h2>Flats Details</h2>
	<table border=2 align=center>
		<tr>
			<th>FLAT_NO</th>
			<th>FLAT_RATE</th>
			<th>FLAT_TYPE</th>
			<th>FLOOR</th>
			<th>LANDLORD_VACANCY</th>
			<th>TENANT_VACANCY</th>
			<th>LANDLORD_ID</th>
			
		</tr>
		<c:forEach var="rooms" items="${roomsData}">
			<tr>
				<td>${rooms.flatNo}</td>
				<td>${rooms.flatRate}</td>
				<td>${rooms.flatType}</td>
				<td>${rooms.floor}</td>
				<td>${rooms.landlordvacancy}</td>
				<td>${rooms.vacancy}</td>
				<td>${rooms.landlords.landlordId}</td>
				</tr>
		</c:forEach>
	</table>

</body>
</html>