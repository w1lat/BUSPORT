<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Buses</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
						<th hidden>ID</th>
				        <th>Model</th>
				        <th>Registry Number</th>
						<th>Count of sits</th>
						<th>Fuel Consumption per 100km</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${buses}" var="bus">
					<tr>
						<td hidden>${bus.id}</td>
						<td>${bus.model}</td>
						<td>${bus.registryNumber}</td>
						<td>${bus.sitsCount}</td>
						<td>${bus.fuelConsumptionPer100KM}</td>
						<td><a href="<c:url value='/edit-bus-${bus.id}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-bus-${bus.id}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/addBus' />">Add New Bus</a>
	 	</div>
		<span class="well middle">
        	<a href="<c:url value='/allDrivers' />" class="btn btn-primary btn-md">Drivers List</a>
        	<a href="<c:url value='/allStations' />" class="btn btn-primary btn-md">Stations List</a>
        	<a href="<c:url value='/allRoutes' />" class="btn btn-primary btn-md">Routes List</a>
        	<a href="<c:url value='/allBuses' />" class="btn btn-primary btn-md">Buses List</a>
    	</span>
   	</div>
</body>
</html>