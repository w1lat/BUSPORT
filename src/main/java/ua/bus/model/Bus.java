package ua.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "buses")
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Bus extends GeneratedIdentifierEntity{

    @Column(length = 50, nullable = false)
    private String model;
    @Column(length = 10, unique = true)
    private String registryNumber;
    @Column(length = 2, nullable = false)
    private int sitsCount;
    @Column(precision = 4, scale = 2)
    private BigDecimal fuelConsumptionPer100KM;
}
