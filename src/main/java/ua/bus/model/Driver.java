package ua.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Data
@Table(name = "drivers")
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends GeneratedIdentifierEntity{

    @Column(length = 25, nullable = false)
    private String name;
    @Column(length = 25, nullable = false)
    private String surName;
    @Column(length = 25)
    private String lastName;
//    @Column(length = 10, nullable = false)
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "license_id", referencedColumnName = "id")
//    private DrivingLicense drivingLicense;
    @Column(length = 10, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private int expirience;
}
