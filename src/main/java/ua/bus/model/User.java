package ua.bus.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Table(name = "users")
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

    public User() {
    }

    public User(String name, String surName, String email, String phone, String password, LocalDate birthDay, Set<Ticket> tickets) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.birthDay = birthDay;
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
