package ua.bus.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Vitalii on 07.11.2017.
 */
@Entity
@Table(name = "waypoints")
public class WayPoint extends GeneratedIdentifierEntity{

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinColumn(name = "station_id")
    private Station station;
//    @Column(length = 10, nullable = true)
//    private LocalDate dateOfDeparture;
//    @Column(length = 10, nullable = true)
//    private LocalDate dateOfArrival;
//    @Column(length = 10, nullable = true)
//    private LocalTime timeOfDeparture;
//    @Column(length = 10, nullable = true)
//    private LocalTime timeOfArrival;

    public WayPoint() {
    }

    public WayPoint(Station station, LocalDate dateOfDeparture, LocalDate dateOfArrival, LocalTime timeOfDeparture, LocalTime timeOfArrival) {
        this.station = station;
//        this.dateOfDeparture = dateOfDeparture;
//        this.dateOfArrival = dateOfArrival;
//        this.timeOfDeparture = timeOfDeparture;
//        this.timeOfArrival = timeOfArrival;
    }

    public WayPoint(Station station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WayPoint wayPoint = (WayPoint) o;

        if (!station.equals(wayPoint.station)) return false;
//        if (!dateOfDeparture.equals(wayPoint.dateOfDeparture)) return false;
//        if (!dateOfArrival.equals(wayPoint.dateOfArrival)) return false;
//        if (!timeOfDeparture.equals(wayPoint.timeOfDeparture)) return false;
        return station.equals(wayPoint.station);

    }

    @Override
    public int hashCode() {
        int result = station.hashCode();
//        result = 31 * result + dateOfDeparture.hashCode();
//        result = 31 * result + dateOfArrival.hashCode();
//        result = 31 * result + timeOfDeparture.hashCode();
//        result = 31 * result + timeOfArrival.hashCode();
        return result;
    }

    public void setStation(Station station) {
        this.station = station;
    }

//    public LocalDate getDateOfDeparture() {
//        return dateOfDeparture;
//    }
//
//    public void setDateOfDeparture(LocalDate dateOfDeparture) {
//        this.dateOfDeparture = dateOfDeparture;
//    }
//
//    public LocalDate getDateOfArrival() {
//        return dateOfArrival;
//    }
//
//    public void setDateOfArrival(LocalDate dateOfArrival) {
//        this.dateOfArrival = dateOfArrival;
//    }
//
//    public LocalTime getTimeOfDeparture() {
//        return timeOfDeparture;
//    }
//
//    public void setTimeOfDeparture(LocalTime timeOfDeparture) {
//        this.timeOfDeparture = timeOfDeparture;
//    }
//
//    public LocalTime getTimeOfArrival() {
//        return timeOfArrival;
//    }
//
//    public void setTimeOfArrival(LocalTime timeOfArrival) {
//        this.timeOfArrival = timeOfArrival;
//    }

    public Station getStation() {
        return station;
    }
}
