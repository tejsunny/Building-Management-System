<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,com.ts.dto.Rooms" import="java.util.ArrayList,com.ts.dto.Tenants"
    import="java.util.ArrayList,com.ts.dto.Landlords"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="style1.css">
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

</style>

</head>
<body>
    <h1><center><b>OWNING A HOME IS A KEYSTONE OF WEALTH</b></center></h1>

	<table border=2 align=center>
		<tr>
			<th>FLAT_NO</th>
			<th>FLAT_TYPE</th>
			<th>FLOOR</th>
			<th>FLAT_RATE</th>
		</tr>
		<c:forEach var="room" items="${flatsForSale}">
	    <tr>	
				<td>${room.flatNo}</td>
				<td>${room.flatType}</td>
				<td>${room.floor}</td>
				<td>${room.flatRate}</td>				
		</tr>
		</c:forEach>
	</table>
	<h3><center><b>FOR FURTHER DETAILS</b></center></h3>
	<h4><center><b>Contact:9768545642</b></center></h4>

</body>
</html>