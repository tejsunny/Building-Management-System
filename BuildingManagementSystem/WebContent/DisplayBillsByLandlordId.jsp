
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,com.ts.dto.Rooms" import= "java.util.ArrayList,com.ts.dto.Bills"%>
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
<jsp:include page="Landlords.jsp" />
<h2>Bills....</h2>
	<table border=2 align=center>
		<tr>
			<th>ROOM_NO</th>
			<th>TENANT_NAME</th>
			<th>WATER_BILL</th>
			<th>ELECTRICITY_BILL</th>
			<th>MAINTINANCE_BILL</th>	

		</tr>
		<c:forEach var="room" items="${roomsData}">
			<tr>
				<td>${room.flatNo}</td>
				<td>${room.tenants.tenantName}</td>
		<c:forEach var="bills" items="${room.bills}">
				<td>${bills.waterBill}</td>
				<td>${bills.electricityBill}</td>
				<td>${bills.maintenanceBill}</td>
			</tr>
		</c:forEach>
		</c:forEach>
	</table>


</body>
</html>