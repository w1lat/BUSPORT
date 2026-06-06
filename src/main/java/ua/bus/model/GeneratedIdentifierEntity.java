package ua.bus.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Created by vitalii on 03.04.17.
 */
@Data
@MappedSuperclass
@SuperBuilder
@ToString
public class GeneratedIdentifierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public GeneratedIdentifierEntity() {}
}
