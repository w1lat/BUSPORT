package ua.bus.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitalii on 03.04.17.
 */
@Data
@Table(name = "routes")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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
    @Builder.Default
    private List<WayPoint> wayPoints = new ArrayList<>();

    public String generateRouteCode() {
        String departureStationCode = wayPoints.get(0).getStation().getStationCode();
        int countOfStations = wayPoints.size();
        int routeNumber = this.routeNumber++;
        String arrivalStationCode = wayPoints.get(countOfStations - 1).getStation().getStationCode();
        this.setRouteCode(routeNumber + departureStationCode + countOfStations + arrivalStationCode);
        return routeCode;
    }

    public Route(Bus bus, Driver driver/*, List<WayPoint> wayPoints*/) {
        this.bus = bus;
        this.driver = driver;
        /*this.wayPoints = wayPoints;*/
        generateRouteCode();
    }
}

