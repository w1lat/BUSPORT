package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.WayPoint;

public interface WayPointRepository extends CrudRepository<WayPoint, Long> {
}
