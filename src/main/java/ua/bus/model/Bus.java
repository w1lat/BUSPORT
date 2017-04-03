package ua.bus.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Created by vitalii on 03.04.17.
 */
@Table(name = "buses")
public class Bus extends GeneratedIdentifierEntity{

    @Column(length = 20, nullable = false)
    private String model;
    @Column(length = 10)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;
    @Column(length = 10, unique = true)
    private String registryNumber;
    @Column(length = 2, nullable = false)
    private int sitsCount;
    @Column(length = 4, precision = 4, scale = 2)
    private float fuelConsumption;

    public Bus() {
    }

    public Bus(String model, Driver driver, String registryNumber, int sitsCount, float fuelConsumption) {
        this.model = model;
        this.driver = driver;
        this.registryNumber = registryNumber;
        this.sitsCount = sitsCount;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public int getSitsCount() {
        return sitsCount;
    }

    public void setSitsCount(int sitsCount) {
        this.sitsCount = sitsCount;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
