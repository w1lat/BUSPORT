package ua.bus.controllers;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.bus.model.Route;
import ua.bus.model.WayPoint;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RoutesControllerTest extends InitAppContextTestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoutesControllerTest.class);

    @Test
    public void testCreateRoute() {
        WayPoint wayPoint1 = new WayPoint(station1, LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now());
        WayPoint wayPoint2 = new WayPoint(station2, LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now());
        List<WayPoint> wayPoints = new ArrayList<>();
        wayPoints.add(wayPoint1);
        wayPoints.add(wayPoint2);
        Route route = Route.builder()
                .bus(bus)
                .driver(driver)
                .wayPoints(wayPoints)
                .build();
        route.generateRouteCode();

        LOGGER.info(route.getBus().toString());
        LOGGER.info(route.getDriver().toString());
        LOGGER.info(route.getWayPoints().toString());
        LOGGER.info(route.getRouteCode());
        LOGGER.info(String.valueOf(route.getId()));

//        assertTrue("Player loose", gameContext.getGameResult() == GameResult.LOOSE);
    }
}
