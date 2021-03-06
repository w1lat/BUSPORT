<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>

<div class="generic-container" align="middle">
    <div class="well lead">Adding driver Form</div>
    <form:form method="POST" modelAttribute="driver" class="form-horizontal">

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
                <label class="col-md-3 control-lable" for="name">First Name</label>

                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>

                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="surName">Surname</label>

                <div class="col-md-7">
                    <form:input type="text" path="surName" id="surName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="surName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="birthDay">Birthday</label>

                <div class="col-md-7">
                    <form:input type="date" path="birthDay" id="birthDay" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="birthDay" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allDrivers' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/allDrivers' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    <span class="well floatRight">
        <a href="<c:url value='/allDrivers' />" class="btn btn-primary btn-md">Drivers List</a>
        <a href="<c:url value='/allStations' />" class="btn btn-primary btn-md">Stations List</a>
        <a href="<c:url value='/allRoutes' />" class="btn btn-primary btn-md">Routes List</a>
        <a href="<c:url value='/allBuses' />" class="btn btn-primary btn-md">Buses List</a>
    </span>
</div>
</body>
</html>