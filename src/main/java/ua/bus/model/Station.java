package ua.bus.model;

import org.hibernate.annotations.CollectionId;
import ua.bus.model.utils.Coordinates;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Vitalii on 02.09.2017.
 */
@Entity
@Table(name = "stations")
public class Station extends GeneratedIdentifierEntity{

    @Column(unique = true, length = 10, nullable = false)
    private String stationCode;
    @Column(unique = true, length = 25, nullable = false)
    private String stationName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", referencedColumnName = "id")
    private Coordinates coordinates;
    @Column(length = 10, nullable = true)
    private LocalDate dateOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalDate dateOfArrival;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfArrival;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (stationCode != null ? !stationCode.equals(station.stationCode) : station.stationCode != null) return false;
        if (stationName != null ? !stationName.equals(station.stationName) : station.stationName != null) return false;
        if (coordinates != null ? !coordinates.equals(station.coordinates) : station.coordinates != null) return false;
        if (dateOfDeparture != null ? !dateOfDeparture.equals(station.dateOfDeparture) : station.dateOfDeparture != null)
            return false;
        if (dateOfArrival != null ? !dateOfArrival.equals(station.dateOfArrival) : station.dateOfArrival != null)
            return false;
        if (timeOfDeparture != null ? !timeOfDeparture.equals(station.timeOfDeparture) : station.timeOfDeparture != null)
            return false;
        return !(timeOfArrival != null ? !timeOfArrival.equals(station.timeOfArrival) : station.timeOfArrival != null);

    }

    @Override
    public int hashCode() {
        int result = stationCode != null ? stationCode.hashCode() : 0;
        result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (dateOfDeparture != null ? dateOfDeparture.hashCode() : 0);
        result = 31 * result + (dateOfArrival != null ? dateOfArrival.hashCode() : 0);
        result = 31 * result + (timeOfDeparture != null ? timeOfDeparture.hashCode() : 0);
        result = 31 * result + (timeOfArrival != null ? timeOfArrival.hashCode() : 0);
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public LocalTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(LocalTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }
}

