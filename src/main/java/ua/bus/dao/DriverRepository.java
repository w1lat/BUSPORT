package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.bus.model.Driver;

/**
 * Created by vitalii on 06.04.17.
 */
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {
}
