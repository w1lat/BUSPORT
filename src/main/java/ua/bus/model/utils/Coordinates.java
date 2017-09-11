package ua.bus.model.utils;

import ua.bus.model.GeneratedIdentifierEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vitalii on 02.09.2017.
 */
@Entity
@Table(name = "coordinates")
public class Coordinates extends GeneratedIdentifierEntity{

    @Column
    private int latitude;
    @Column
    private int longditude;
}
