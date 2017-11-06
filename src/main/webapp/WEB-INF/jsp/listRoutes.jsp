<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Routes List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Routes</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th hidden>ID</th>
                <th>Route Code</th>
                <th>Bus Number</th>
                <th>Driver</th>
                <th>Departure Station</th>
                <th>Arrival Station</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${routes}" var="route">
                <tr>
                    <td hidden>${route.id}</td>
                    <td>${route.routeCode}</td>
                    <td>${route.bus.registryNumber}</td>
                    <td>${route.driver.surName} ${route.driver.name} ${route.driver.lastName}</td>
                    <td>${route.stations[0].stationName}</td>
                    <td>${route.stations[fn:length(route.stations)-1].stationName}</td>
                    <td><a href="<c:url value='/edit-route-${route.id}' />" class="btn btn-success custom-width">edit</a>
                    </td>
                    <td><a href="<c:url value='/delete-route-${route.id}' />" class="btn btn-danger custom-width">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/addRoute' />">Add New Route</a>
    </div>
</div>
</body>
</html>