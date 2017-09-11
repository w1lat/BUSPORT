package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.Route;

import java.time.LocalDate;
import java.util.Map;

public interface RouteRepository extends CrudRepository<Route, Long> {

//    Map<String, Route> findByDateAndStation(LocalDate date, String stationName);
}
