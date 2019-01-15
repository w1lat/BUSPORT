package ua.bus.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Table(name = "routes")
public class Route extends GeneratedIdentifierEntity{

    private static int routeNumber;
    @Column(name = "route_code", nullable = false, unique = true)
    private String routeCode;
    @OneToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
    @OneToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

//    @OneToMany(cascade = {CascadeType.PERSIST,
//            CascadeType.MERGE})
    @OneToMany(mappedBy = "route",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
//    @JoinTable(name = "route_waypoints",
//            joinColumns = @JoinColumn(name = "route_id"),
//            inverseJoinColumns = @JoinColumn(name = "waypoint_id"))
    private List<WayPoint> wayPoints = new ArrayList<>();

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<WayPoint> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(List<WayPoint> wayPoints) {
        this.wayPoints = wayPoints;
    }

    public String generateRouteCode() {
        String departureStationCode = wayPoints.get(0).getStation().getStationCode();
        int countOfStations = wayPoints.size();
        int routeNumber = this.routeNumber++;
        String arrivalStationCode = wayPoints.get(countOfStations - 1).getStation().getStationCode();
        this.setRouteCode(routeNumber + departureStationCode + countOfStations + arrivalStationCode);
        return routeCode;
    }

    public Route() {
    }

    public Route(Bus bus, Driver driver, List<WayPoint> wayPoints) {
        this.bus = bus;
        this.driver = driver;
        this.wayPoints = wayPoints;
        generateRouteCode();
    }
}

