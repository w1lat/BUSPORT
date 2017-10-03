package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.Station;

/**
 * Created by Vitalii on 18.09.2017.
 */
public interface StationRepository extends CrudRepository<Station, Long> {
}
