package ua.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stations")
public class Station extends GeneratedIdentifierEntity {

    @Column(length = 3, nullable = false)
    private String stationCode;
    @Column(length = 25, nullable = false)
    private String stationName;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coordinates_id", referencedColumnName = "id")
//    private Coordinates coordinates;
//    @ManyToMany(mappedBy = "stations")
//    private List<Route> routes = new ArrayList<>();

    public Station() {
    }

    public Station(String stationCode, String stationName, String dateOfDeparture, String dateOfArrival, String timeOfDeparture, String timeOfArrival) {
        this.stationCode = stationCode;
        this.stationName = stationName;
//        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (!stationCode.equals(station.stationCode)) return false;
        return stationName.equals(station.stationName);

    }

    @Override
    public int hashCode() {
        int result = stationCode != null ? stationCode.hashCode() : 0;
        result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
//        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    public String getStationCode() {

        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

//    public Coordinates getCoordinates() {
//        return coordinates;
////    }
//
//    public void setCoordinates(Coordinates coordinates) {
//        this.coordinates = coordinates;
////    }
//
//    public List<Route> getRoutes() {
//        return routes;
//    }
//
//    public void setRoutes(List<Route> routes) {
//        this.routes = routes;
//    }
}

