<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.ArrayList,com.ts.dto.Rooms" import = "java.util.ArrayList,com.ts.dto.Bills"
    import = "java.util.ArrayList,com.ts.dto.Tenants"%>
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
<jsp:include page="Tenants.jsp" />
<h1>Bills...</h1>
	<table border=2 align=center>
		<tr>
		    <th>FLAT_NO</th>
			<th>TENANT_NAME</th>
			<th>WATER_BILL</th>
			<th>ELECTRICITY_BILL</th>
			<th>MAINTINANCE_BILL</th>	
		</tr>
		
			<tr>
			    <td>${roomData.flatNo}</td>
				<td>${roomData.tenants.tenantName}</td>
				<c:forEach var="bill" items="${roomData.bills}">
				<td>${bill.waterBill}</td>
				<td>${bill.electricityBill}</td>
				<td>${bill.maintenanceBill}</td>
			</c:forEach>	
			</tr>
			
	</table>
</body>
</html>