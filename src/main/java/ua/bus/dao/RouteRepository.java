package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.Driver;
import ua.bus.model.Route;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route> findByDriver(Driver driver);
}
