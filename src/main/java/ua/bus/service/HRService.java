package ua.bus.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.DriverRepository;
import ua.bus.model.Driver;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

@Service
public class HRService {

    private static Logger LOGGER = Logger.getLogger(HRService.class);

    @Autowired
    private DriverRepository driverRepository;

    public Driver addDriver(Driver driver) throws EntitySaveException {
        LOGGER.info("Starting driver adding " + driver.getName() + " " + driver.getSurName());
        Driver saved = driverRepository.save(driver);

        if (saved == null) {
            throw new EntitySaveException(Driver.class);
        }
        return saved;
    }

    public Driver getDriverById(Long id) throws EntityNotFoundException {
        LOGGER.info("Starting driver getting by id " + id);
        Driver gotDriver = driverRepository.findOne(id);

        if (gotDriver == null) {
            throw new EntityNotFoundException(id, Driver.class);
        } else {
            return gotDriver;
        }
    }

    public Driver updateDriver(Driver driver) throws EntitySaveException {
        LOGGER.info("Starting driver updating " + driver.getName() + " " + driver.getSurName());
        Driver updatedDriver = driverRepository.save(driver);

        if (updatedDriver == null) {
            throw new EntitySaveException(Driver.class);
        } else {
            return updatedDriver;
        }
    }

    public Iterable<Driver> getAllDrivers() throws EntityNotFoundException {
        LOGGER.info("Starting all drivers getting");
        Iterable drivers = driverRepository.findAll();

        if (drivers == null) {
            throw new EntityNotFoundException(0, Driver.class);
        } else {
            return drivers;
        }
    }

    public void deleteDriver(Long id) {
        LOGGER.info("Starting driver deleting by id " + id);
        driverRepository.delete(id);
    }
}
