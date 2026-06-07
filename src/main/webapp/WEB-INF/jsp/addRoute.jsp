<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='../../static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='../../static/css/app.css' />" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.7/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#add-btn").on("click", function () {
                $(".btn").hide();
            })
        })
    </script>
</head>

<body>

<div class="generic-container">
    <div class="well lead">Creating Route Form</div>
    <form:form method="POST" modelAttribute="route" class="form-horizontal">

    <div class="row">
        <div class="col-md-7">
            <c:choose>
                <c:when test="${edit}">
                    <form:input type="hidden" path="id" id="id" class="form-control input-sm" disabled="true"/>
                </c:when>
            </c:choose>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="driverList">Route Code</label>

            <div class="col-md-7">
                <c:choose>
                    <c:when test="${edit}">
                        <form:input path="routeCode" id="routeCode" class="form-control input-sm"/>
                    </c:when>
                </c:choose>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="driverList">Choose driver</label>

                <div class="col-md-7">
                    <select name="driver" id="driverList">
                        <c:choose>
                            <c:when test="${not empty driverList}">
                                <c:forEach items="${driverList}" var="driver">
                                    <option value="${driver.id}" ${driver.id == route.driver.id ? 'selected="selected"' : ''}>${driver.name} ${driver.lastName} ${driver.surName}</option>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <option disabled="disabled">No drivers available</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="busList">Choose Bus</label>

                <div class="col-md-7">
                    <select name="bus" id="busList">
                        <c:choose>
                            <c:when test="${not empty busList}">
                                <c:forEach items="${busList}" var="bus">
                                    <option value="${bus.id}" ${bus.id == route.bus.id ? 'selected="selected"' : ''}>${bus.model} ${bus.registryNumber}</option>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <option disabled="disabled">No buses available</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="departure_station">Choose station of departure</label>

                <div class="col-md-7">
                    <select name="departureStationId" id="departure_station">
                        <c:choose>
                            <c:when test="${not empty stationsList}">
                                <c:forEach items="${stationsList}" var="station">
                                    <option value="${station.id}" ${station.id == route.wayPoints[0].station.id ? 'selected="selected"' : ''}>
                                            ${station.stationCode} ${station.stationName}
                                    </option>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <option disabled="disabled">No stations available</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="arrival_station">Choose station of arriving</label>

                <div class="col-md-7">
                    <select name="arrivalStationId" id="arrival_station">
                        <c:choose>
                            <c:when test="${not empty stationsList}">
                                <c:forEach items="${stationsList}" var="station">
                                    <option value="${station.id}" ${station.id == route.wayPoints[fn:length(route.wayPoints)-1].station.id ? 'selected="selected"' : ''}>
                                            ${station.stationCode} ${station.stationName}
                                    </option>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <option disabled="disabled">No stations available</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allRoutes' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allRoutes' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        </form:form>
        <span class="well floatCenter">
            <a href="<c:url value='/allDrivers' />" class="btn btn-primary btn-md">Drivers List</a>
            <a href="<c:url value='/allStations' />" class="btn btn-primary btn-md">Stations List</a>
            <a href="<c:url value='/allRoutes' />" class="btn btn-primary btn-md">Routes List</a>
            <a href="<c:url value='/allBuses' />" class="btn btn-primary btn-md">Buses List</a>
        </span>
    </div>
</body>
</html>