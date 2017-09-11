package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.bus.model.Driver;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findByLastName(String lastName);
}
