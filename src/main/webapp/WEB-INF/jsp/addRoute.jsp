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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#add-btn").on("click", function () {
                $(".btn").hide();
            })
        })
    </script>

    <script>
        $(document).ready(function () {
            $("#addStationBtn").on("click", function () {
                const optionsHtml = $("#wayPointsContainer select:first").html();

                const newRow =
                    '<div class="row mt-2 waypoint-row">' +
                    '<div class="form-group col-md-12">' +
                    '<label class="col-md-3 control-lable">Intermediate station</label>' +
                    '<div class="col-md-7">' +
                    '<select class="form-control">' +
                    optionsHtml +
                    '</select>' +
                    '</div>' +
                    '<div class="col-md-2">' +
                    '<button type="button" class="btn btn-danger btn-sm removeStationBtn">? Remove</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

                // Insert before the last row (arrival)
                $("#wayPointsContainer .waypoint-row:last").before(newRow);
                reindexWayPoints();
            });

            $(document).on("click", ".removeStationBtn", function () {
                $(this).closest(".waypoint-row").remove();
                reindexWayPoints();
            });

            function reindexWayPoints() {
                $("#wayPointsContainer .waypoint-row").each(function (index) {
                    const label = $(this).find("label");
                    const select = $(this).find("select");

                    if (index === 0) {
                        label.text("Departure station");
                    } else if (index === $("#wayPointsContainer .waypoint-row").length - 1) {
                        label.text("Arrival station");
                    } else {
                        label.text("Intermediate station " + index);
                    }

                    select.attr("name", "wayPoints[" + index + "].station.id");
                });
            }

            reindexWayPoints();
        });
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
            <label class="col-md-3 control-lable" for="routeCode">Route Code</label>

            <div class="col-md-7">
                <c:choose>
                    <c:when test="${edit}">
                        <form:input path="routeCode" id="routeCode" class="form-control input-sm" readonly="true"/>
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

        <div id="wayPointsContainer">
            <!-- Departure -->
            <div class="row mt-2 waypoint-row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable">Departure station</label>
                    <div class="col-md-7">
                        <select name="wayPoints[0].station" id="departure_station" class="form-control">
                            <c:forEach items="${stationsList}" var="station">
                                <option value="${station.id}"
                                        <c:if test="${not empty route.wayPoints and station.id == route.wayPoints[0].station.id}">
                                            selected="selected"
                                        </c:if>>
                                        ${station.stationCode} ${station.stationName}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <button type="button" id="addStationBtn" class="btn btn-sm btn-primary">+ Station</button>
                    </div>
                </div>
            </div>

            <!-- Intermediate stations (only if exist) -->
            <c:if test="${fn:length(route.wayPoints) > 2}">
                <c:forEach var="wp" items="${route.wayPoints}" begin="1" end="${fn:length(route.wayPoints)-2}" varStatus="status">
                    <div class="row mt-2 waypoint-row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable">Intermediate station ${status.index}</label>
                            <div class="col-md-7">
                                <select name="wayPoints[${status.index}].station" class="form-control">
                                    <c:forEach items="${stationsList}" var="station">
                                        <option value="${station.id}"
                                                <c:if test="${station.id == wp.station.id}">selected="selected"</c:if>>
                                                ${station.stationCode} ${station.stationName}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <button type="button" class="btn btn-danger btn-sm removeStationBtn">? Remove</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <!-- Arrival -->
            <div class="row mt-2 waypoint-row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable">Arrival station</label>
                    <div class="col-md-7">
                        <select name="wayPoints[${fn:length(route.wayPoints) > 0 ? fn:length(route.wayPoints)-1 : 1}].station"
                                id="arrival_station" class="form-control">
                            <c:forEach items="${stationsList}" var="station">
                                <option value="${station.id}"
                                        <c:if test="${fn:length(route.wayPoints) > 1 and station.id == route.wayPoints[fn:length(route.wayPoints)-1].station.id}">
                                            selected="selected"
                                        </c:if>>
                                        ${station.stationCode} ${station.stationName}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
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