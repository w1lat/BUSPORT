package ua.bus.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Data
@Table(name = "routes")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Route extends GeneratedIdentifierEntity{

    private static int routeNumber = 0;
    @Column(name = "route_code", nullable = false, unique = true)
    private String routeCode;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    @OneToMany(mappedBy = "route",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @Builder.Default
    @OrderColumn(name = "position")
    private List<WayPoint> wayPoints = new LinkedList<>();

    public String generateRouteCode(String departureStationCode, String arrivalStationCode) {
        int countOfStations = wayPoints.size();
        int routeNumber = Route.routeNumber++;
        this.setRouteCode(routeNumber + departureStationCode + countOfStations + arrivalStationCode);
        return routeCode;
    }

//    public Route(Bus bus, Driver driver/*, List<WayPoint> wayPoints*/) {
//        this.bus = bus;
//        this.driver = driver;
//        /*this.wayPoints = wayPoints;*/
//        generateRouteCode();
//    }

    public void addWayPointToTheEndOfRoute(WayPoint wayPoint) {
        wayPoint.setRoute(this);
        this.wayPoints.add(wayPoint);
    }
}

