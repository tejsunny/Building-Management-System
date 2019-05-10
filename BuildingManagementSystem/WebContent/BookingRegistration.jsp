<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,com.ts.dto.Facilities"
    import="java.util.List,com.ts.dao.FacilitiesDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
<title>Insert title here</title>
</head>
<% 
FacilitiesDAO facilityDao = new FacilitiesDAO();
List<Facilities> facilitiesData = facilityDao.getAllFacilities();
request.setAttribute("facilitiesData", facilitiesData); 
%>

<body>
<button class="open-button" onclick="openForm()">Click here to register</button>

<div class="form-popup" id="myForm">
  <form action="BookingRegistration" class="form-container">
    <h1>SignUp</h1>

    <label for="FlatNo"><b>FlatNo</b></label>
    <input type="text" placeholder="Enter FlatNo" name="flatNo" required>

    <label for="NoOfParticipants"><b>NoOfParticipants</b></label>
    <input type="text" placeholder="Enter NoOfParticipants" name="noOfParticipants" required>
    Select Aminity : <select name="facilityId">
    <c:forEach var="facility" items="${facilitiesData}">
    <option value="${facility.facilityId}">${facility.facilityName}</option>
    </c:forEach>
    </select>    
    <button type="submit" class="btn">SignUp</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
</body>
</html>