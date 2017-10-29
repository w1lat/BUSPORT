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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "route_stations",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<Station> stations = new ArrayList<>();

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

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public String generateRouteCode() {
        String departureStationCode = stations.get(0).getStationCode();
        int countOfStations = stations.size();
        int routeNumber = this.routeNumber++;
        String arrivalStationCode = stations.get(countOfStations - 1).getStationCode();
        this.setRouteCode(routeNumber + departureStationCode + countOfStations + arrivalStationCode);
        return routeCode;
    }

    public Route() {
    }

    public Route(Bus bus, Driver driver, List<Station> stations) {
        this.bus = bus;
        this.driver = driver;
        this.stations = stations;
        generateRouteCode();
    }
}

