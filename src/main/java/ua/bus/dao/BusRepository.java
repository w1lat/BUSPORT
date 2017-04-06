package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.bus.model.Bus;

/**
 * Created by vitalii on 06.04.17.
 */
@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {
}
