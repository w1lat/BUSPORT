package ua.bus.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by vitalii on 03.04.17.
 */
@Entity
@Table(name = "drivers")
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
    private LocalDate birthDay;

    public Driver() {
    }

    public Driver(String name, String surName, String lastName, String birthDay) {
        this.name = name;
        this.surName = surName;
        this.lastName = lastName;
//        this.drivingLicense = drivingLicense;
        this.birthDay = LocalDate.parse(birthDay);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public DrivingLicense getDrivingLicense() {
//        return drivingLicense;
//    }
//
//    public void setDrivingLicense(DrivingLicense drivingLicense) {
//        this.drivingLicense = drivingLicense;
//    }

    public String getBirthDay() {
        if(this.birthDay == null){
            return null;
        }else {
            return birthDay.toString();
        }
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = LocalDate.parse(birthDay);
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
