<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.ArrayList,com.ts.dto.Facilities"%>
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
<h2>Facilities</h2>
	<table border=2 align=center>
		<tr>
			<th>FACILITY_ID</th>
			<th>NAME</th>
			<th>LIMIT</th>
			
		</tr>
		<c:forEach var="facilities" items="${FacilitiesData}">
			<tr>
				<td>${facilities.facilityId}</td>
				<td>${facilities.facilityName}</td>
				<td>${facilities.limitedPeople}</td>
				</tr>
		</c:forEach>
	</table>

</body>
</html>