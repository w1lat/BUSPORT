package ua.bus.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "buses")
public class Bus extends GeneratedIdentifierEntity{

    @Column(length = 20, nullable = false)
    private String model;
    @Column(length = 10, unique = true)
    private String registryNumber;
    @Column(length = 2, nullable = false)
    private int sitsCount;
    @Column(length = 4, precision = 4, scale = 2)
    private float fuelConsumptionPer100KM;

    public Bus() {
    }

    public Bus(String model, String registryNumber, int sitsCount, float fuelConsumption) {
        this.model = model;
        this.registryNumber = registryNumber;
        this.sitsCount = sitsCount;
        this.fuelConsumptionPer100KM = fuelConsumption;
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

    public float getFuelConsumptionPer100KM() {
        return fuelConsumptionPer100KM;
    }

    public void setFuelConsumptionPer100KM(float fuelConsumptionPer100KM) {
        this.fuelConsumptionPer100KM = fuelConsumptionPer100KM;
    }
}
