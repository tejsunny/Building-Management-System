<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 25px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.topnav-right {
  float: right;
}
</style>

</head>
<body>
<div class="topnav">
<div class="topnav-right">
    <a href="Logout.jsp">LOGOUT</a>
</div>
</div>


<div class="container">

  <h2><strong>Hii LandLord!!</strong></strong></h2>
  <div class="alert alert-success">
    <a href="LandlordProfile" class="alert-link">My PROFILE</a>.
  </div>
  <div class="alert alert-success">
    <a href="DisplayTenants" class="alert-link">TENANTS</a>.
  </div>
  <div class="alert alert-warning">
    <a href="DisplayFacilities" class="alert-link">FACILITIES</a>.
  </div>
  <div class="alert alert-danger">
    <a href="DisplayBills" class="alert-link">BILLS</a>.
  </div>
</div>

</body>
</html>
