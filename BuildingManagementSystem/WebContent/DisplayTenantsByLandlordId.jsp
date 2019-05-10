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
<jsp:include page="Landlords.jsp" />
<h2>Landlords Details</h2>
	<table border=2 align=center>
		<tr>
			<th>FLATNO</th>
			<th>ID</th>
			<th>NAME</th>
			<th>PNUMBER</th>
		</tr>
		<c:forEach var="rooms" items="${roomsData}">
			<tr>
			    <td>${rooms.flatNo}</td>
				<td>${rooms.tenants.tenantId}</td>
				<td>${rooms.tenants.tenantName}</td>
				<td>${rooms.tenants.tenantPhNumber}</td>
				<td><a href='RegisterTenant.jsp'>REGISTER</a></td>
				<td><a href='DeleteTenantServlet?flatNo=${rooms.flatNo}'>DELETE</a></td>

				</tr>
		</c:forEach>
	</table>


</body>
</html>