package ua.bus.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Data
@Table(name = "users")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class User extends GeneratedIdentifierEntity{

    @Column(length = 25, nullable = false)
    private String name;
    @Column(length = 25, nullable = false)
    private String surName;
    @Column(length = 30, nullable = false, unique = true)
    private String email;
    @Column(length = 15, unique = true)
    private String phone;
    @Column(length = 50, nullable = false)
    private String password;
    @Column(length = 10)
    private LocalDate birthDay;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;
}
