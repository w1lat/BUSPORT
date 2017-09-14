package ua.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.DriverRepository;
import ua.bus.model.Driver;
import ua.bus.utils.exceptions.DriverNotFoundException;
import ua.bus.utils.exceptions.DriverSaveException;

import java.util.List;

@Service
public class HRService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver addDriver(Driver driver) throws DriverSaveException {
        Driver saved = driverRepository.save(driver);

        if (saved == null){
            throw new DriverSaveException();
        }
        return saved;
    }

    public Driver getDriverById(Long id) throws DriverNotFoundException {
        Driver gotDriver = driverRepository.findOne(id);

        if(gotDriver == null){
            throw new DriverNotFoundException(id);
        }else{
            return gotDriver;
        }
    }

    public Driver updateDriver(Driver driver) throws DriverSaveException {
        Driver updatedDriver = driverRepository.save(driver);

        if(updatedDriver == null){
            throw new DriverSaveException();
        }else{
            return updatedDriver;
        }
    }

    public Iterable<Driver> getAllDrivers() throws DriverNotFoundException {
        Iterable drivers = driverRepository.findAll();

        if(drivers == null){
            throw new DriverNotFoundException(0);
        }else{
            return drivers;
        }
    }

    public void deleteDriver(Long id){
        driverRepository.delete(id);
    }
}
