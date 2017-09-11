package ua.bus.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Table(name = "routes")
public class Route extends GeneratedIdentifierEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Station> stations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (bus != null ? !bus.equals(route.bus) : route.bus != null) return false;
        if (driver != null ? !driver.equals(route.driver) : route.driver != null) return false;
        return !(stations != null ? !stations.equals(route.stations) : route.stations != null);

    }

    @Override
    public int hashCode() {
        int result = bus != null ? bus.hashCode() : 0;
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + (stations != null ? stations.hashCode() : 0);
        return result;
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
}

