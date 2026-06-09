package ua.bus.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "waypoints")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class WayPoint extends GeneratedIdentifierEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    private Station station;
    @Column(length = 10, nullable = true)
    private LocalDate dateOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalDate dateOfArrival;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfDeparture;
    @Column(length = 10, nullable = true)
    private LocalTime timeOfArrival;
    @Column(nullable = false)
    private int position;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    public WayPoint(Station station, LocalDate dateOfDeparture, LocalDate dateOfArrival, LocalTime timeOfDeparture, LocalTime timeOfArrival) {
        this.station = station;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
    }

    public WayPoint(Station station) {
        this.station = station;
    }
}
