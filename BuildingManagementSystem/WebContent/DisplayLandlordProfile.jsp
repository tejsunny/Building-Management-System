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
<h2>PROFILE</h2>
	<table border=2 align=center>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PNUMBER</th>
			<th>PASSWORD</th>
			<th>UPDATE</th>		
		</tr>
     			<tr>
				<td>${landlordsData.landlordId}</td>
				<td>${landlordsData.landlordName}</td>
				<td>${landlordsData.landlordPhNumber}</td>
				<td>${landlordsData.landlordPassword}</td>
				<td><a href='EditLandlordProfile?landlordId=${landlordsData.landlordId}'>UPDATE</a></td>
				
				</tr>
	</table>


</body>
</html>
</body>
</html>