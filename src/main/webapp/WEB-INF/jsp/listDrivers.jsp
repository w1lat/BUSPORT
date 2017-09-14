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
		  	<div class="panel-heading"><span class="lead">List of Drivers </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
						<th hidden>ID</th>
				        <th>Firstname</th>
				        <th>Lastname</th>
						<th>Surname</th>
						<th>Birthday</th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${drivers}" var="driver">
					<tr>
						<td hidden>${driver.id}</td>
						<td>${driver.name}</td>
						<td>${driver.lastName}</td>
						<td>${driver.surName}</td>
						<td>${driver.birthDay}</td>
						<td><a href="<c:url value='/edit-driver-${driver.id}' />" class="btn btn-success custom-width">edit</a></td>
						<td><a href="<c:url value='/delete-driver-${driver.id}' />" class="btn btn-danger custom-width">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/addDriver' />">Add New Driver</a>
	 	</div>
   	</div>
</body>
</html>