package ua.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.DriverRepository;
import ua.bus.model.Driver;
import ua.bus.utils.exceptions.DriverSaveException;

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
}
