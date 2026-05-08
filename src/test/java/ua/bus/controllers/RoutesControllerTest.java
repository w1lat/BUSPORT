package ua.bus.controllers;

import org.apache.log4j.Logger;
import org.junit.Test;
import ua.bus.model.Route;
import ua.bus.model.WayPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RoutesControllerTest extends InitAppContextTestBase{

    private static final Logger LOGGER = Logger.getLogger(RoutesControllerTest.class);

    @Test
    public void testCreateRoute(){
        WayPoint wayPoint1 = new WayPoint(station1, LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now());
        WayPoint wayPoint2 = new WayPoint(station2, LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now());
        List<WayPoint> wayPoints = new ArrayList<>();
        wayPoints.add(wayPoint1);
        wayPoints.add(wayPoint2);
        Route route = new Route();
        route.setBus(bus);
        route.setDriver(driver);
//        route.setWayPoints(wayPoints);
        route.generateRouteCode();

        LOGGER.info(route.getBus());
        LOGGER.info(route.getDriver());
//        LOGGER.info(route.getWayPoints());
        LOGGER.info(route.getRouteCode());
        LOGGER.info(route.getId());

//        assertTrue("Player loose", gameContext.getGameResult() == GameResult.LOOSE);
    }
}
