<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
	<div class="alert alert-success lead">
    	${success}
	</div>
	
	<span class="well floatRight">
		<a href="<c:url value='/allDrivers' />" class="btn btn-primary btn-md">Drivers List</a>
		<a href="<c:url value='/allStations' />" class="btn btn-primary btn-md">Stations List</a>
		<a href="<c:url value='/allRoutes' />" class="btn btn-primary btn-md">Routes List</a>
		<a href="<c:url value='/allBuses' />" class="btn btn-primary btn-md">Buses List</a>
	</span>
</div>
</body>

</html>