<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bus Adding Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="generic-container" align="middle">
    <div class="well lead">Adding Bus Form</div>
    <form:form method="POST" modelAttribute="bus" class="form-horizontal">
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
                <label class="col-md-3 control-lable" for="model">Bus Model</label>

                <div class="col-md-7">
                    <form:input type="text" path="model" id="model" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="model" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="registryNumber">Registry Number</label>

                <div class="col-md-7">
                    <form:input type="text" path="registryNumber" id="registryNumber" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="registryNumber" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="sitsCount">Count of Sits</label>

                <div class="col-md-7">
                    <form:input type="number" path="sitsCount" id="sitsCount" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="sitsCount" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="fuelConsumptionPer100KM">Consumption of fuel per 100km</label>

                <div class="col-md-7">
                    <form:input type="number" path="fuelConsumptionPer100KM" id="fuelConsumptionPer100KM" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="fuelConsumptionPer100KM" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allBuses' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allBuses' />">Cancel</a>
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