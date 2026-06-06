package ua.bus.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by vitalii on 03.04.17.
 */
@Data
@Table(name = "tickets")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Ticket extends GeneratedIdentifierEntity{

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @Column(length = 2, nullable = false)
    private int place;
    @OneToOne(cascade = CascadeType.ALL)
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
}
