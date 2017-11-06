<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="generic-container" align="middle">
    <div class="well lead">Creating Route Form</div>
    <form:form method="POST" modelAttribute="route" class="form-horizontal">

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
                        <c:forEach items="${driverList}" var="driver">
                            <%--<option value="${driver.id}"><c:out value="${driver.name} ${driver.lastName} ${driver.surName}"/></option>--%>
                            <option value="${driver.id}" ${driver.id == route.driver.id ? 'selected="selected"' : ''}>${driver.name} ${driver.lastName} ${driver.surName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="busList">Choose Bus</label>

                <div class="col-md-7">
                    <select name="bus" id="busList">
                        <c:forEach items="${busList}" var="bus">
                            <%--<option value="${bus.id}"><c:out value="${bus.model} ${bus.registryNumber}"/></option>--%>
                            <option value="${bus.id}" ${bus.id == route.bus.id ? 'selected="selected"' : ''}>${bus.model} ${bus.registryNumber}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="arrival_station">Choose station of arrival</label>

                <div class="col-md-7">
                    <select name="stations" id="arrival_station">
                        <c:forEach items="${stationList}" var="station">
                            <%--<option value="${station.id}"><c:out value="${station.stationCode} ${station.stationName}"/></option>--%>
                            <option value="${station.id}" ${station.id == route.stations[0].id ? 'selected="selected"' : ''}>${station.stationCode} ${station.stationName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="departure_station">Choose station of departure</label>

                <div class="col-md-7">
                    <select name="stations" id="departure_station">
                        <c:forEach items="${stationList}" var="station">
                            <%--<option value="${station.id}"><c:out value="${station.stationCode} ${station.stationName}"/></option>--%>
                            <option value="${station.id}" ${station.id == route.stations[fn:length(route.stations)-1].id ? 'selected="selected"' : ''}>${station.stationCode} ${station.stationName}</option>
                        </c:forEach>
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
</div>
</body>
</html>