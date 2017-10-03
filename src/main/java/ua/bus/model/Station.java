package ua.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

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
    @Column(length = 10, nullable = true)
    private LocalDate dateOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalDate dateOfArrival;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfArrival;

    public Station() {
    }

    public Station(String stationCode, String stationName, String dateOfDeparture, String dateOfArrival, String timeOfDeparture, String timeOfArrival) {
        this.stationCode = stationCode;
        this.stationName = stationName;
//        this.coordinates = coordinates;
        this.dateOfDeparture = LocalDate.parse(dateOfDeparture);
        this.dateOfArrival = LocalDate.parse(dateOfArrival);
        this.timeOfDeparture = LocalTime.parse(timeOfDeparture);
        this.timeOfArrival = LocalTime.parse(timeOfArrival);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (stationCode != null ? !stationCode.equals(station.stationCode) : station.stationCode != null) return false;
        if (stationName != null ? !stationName.equals(station.stationName) : station.stationName != null) return false;
//        if (coordinates != null ? !coordinates.equals(station.coordinates) : station.coordinates != null) return false;
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
//        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
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

//    public Coordinates getCoordinates() {
//        return coordinates;
////    }
//
//    public void setCoordinates(Coordinates coordinates) {
//        this.coordinates = coordinates;
////    }

    public String getDateOfDeparture() {

        if (dateOfDeparture == null) {
            return null;
        } else {
            return dateOfDeparture.toString();
        }
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = LocalDate.parse(dateOfDeparture);
    }

    public String getDateOfArrival() {
        if (dateOfArrival == null) {
            return null;
        } else {
            return dateOfArrival.toString();
        }
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = LocalDate.parse(dateOfArrival);
    }

    public String getTimeOfDeparture() {
        if (timeOfDeparture == null) {
            return null;
        } else {
            return timeOfDeparture.toString();
        }
    }

    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = LocalTime.parse(timeOfDeparture);
    }

    public String getTimeOfArrival() {
        if (timeOfArrival == null) {
            return null;
        } else {
            return timeOfArrival.toString();
        }
    }

    public void setTimeOfArrival(String timeOfArrival) {
        this.timeOfArrival = LocalTime.parse(timeOfArrival);
    }
}

