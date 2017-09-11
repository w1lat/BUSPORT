package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.Bus;

public interface BusRepository extends CrudRepository<Bus, Long> {
}
