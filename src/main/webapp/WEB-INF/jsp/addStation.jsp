<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="generic-container">
    <div class="well lead">Station Adding Form</div>
    <form:form method="POST" modelAttribute="station" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

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
                <label class="col-md-3 control-lable" for="stationCode">Station Code</label>

                <div class="col-md-7">
                    <form:input type="text" path="stationCode" id="stationCode" maxlength="3" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="stationCode" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="stationName">Station Name</label>

                <div class="col-md-7">
                    <form:input type="text" path="stationName" id="stationName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="stationName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

    <%--<form:form method="POST" modelAttribute="coordinates" class="form-horizontal">--%>
        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="latitude">Station Latitude</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="number" path="latitude" id="latitude" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="latitude" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="longditude">Station Longditude</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="number" path="longditude" id="longditude" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="longditude" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form:form>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="dateOfDeparture">Date of Departure</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="date" path="dateOfDeparture" id="dateOfDeparture" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="dateOfDeparture" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="dateOfArrival">Date of Arrival</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="date" path="dateOfArrival" id="dateOfArrival" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="dateOfArrival" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="timeOfDeparture">Time of Departure</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="time" path="timeOfDeparture" id="timeOfDeparture" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="timeOfDeparture" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="timeOfArrival">Time of Arrival</label>--%>

                <%--<div class="col-md-7">--%>
                    <%--<form:input type="time" path="timeOfArrival" id="timeOfArrival" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="timeOfArrival" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or
                        <a href="<c:url value='/allStations' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or
                        <a href="<c:url value='/allStations' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    <span class="well center">
        <a href="<c:url value='/allDrivers' />" class="btn btn-primary btn-md">Drivers List</a>
        <a href="<c:url value='/allStations' />" class="btn btn-primary btn-md">Stations List</a>
        <a href="<c:url value='/allRoutes' />" class="btn btn-primary btn-md">Routes List</a>
        <a href="<c:url value='/allBuses' />" class="btn btn-primary btn-md">Buses List</a>
    </span>
</div>
</body>
</html>