package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.bus.model.DrivingLicense;

/**
 * Created by vitalii on 06.04.17.
 */
@Repository
public interface DrivingLicenseRepository extends CrudRepository<DrivingLicense, Long>{
}
