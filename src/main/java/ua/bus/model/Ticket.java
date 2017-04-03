package ua.bus.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by vitalii on 03.04.17.
 */
public class Ticket extends GeneratedIdentifierEntity{

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @Column(length = 2, nullable = false)
    private int place;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
    @Column(length = 10, nullable = false)
    private LocalDate departureDate;
    @Column(nullable = false)
    private LocalTime departureTime;
    @Column(length = 10, nullable = false)
    private LocalDate arrivingDate;
    @Column(nullable = false)
    private LocalTime arrivingTime;
    @Column(length = 25, nullable = false)
    private String departureCity;
    @Column(length = 25, nullable = false)
    private String arrivingCity;

    public Ticket() {
    }

    public Ticket(User owner, int place, Bus bus, LocalDate departureDate, LocalTime departureTime, LocalDate arrivingDate, LocalTime arrivingTime, String departureCity, String arrivingCity) {
        this.owner = owner;
        this.place = place;
        this.bus = bus;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivingDate = arrivingDate;
        this.arrivingTime = arrivingTime;
        this.departureCity = departureCity;
        this.arrivingCity = arrivingCity;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(LocalDate arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public LocalTime getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(LocalTime arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivingCity() {
        return arrivingCity;
    }

    public void setArrivingCity(String arrivingCity) {
        this.arrivingCity = arrivingCity;
    }
}
