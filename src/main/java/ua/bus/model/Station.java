package ua.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Table(name = "stations")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Station extends GeneratedIdentifierEntity {

    @Column(length = 3, nullable = false)
    private String stationCode;
    @Column(length = 25, nullable = false)
    private String stationName;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coordinates_id", referencedColumnName = "id")
//    private Coordinates coordinates;
}

