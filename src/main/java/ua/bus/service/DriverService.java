package ua.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.RouteRepository;
import ua.bus.model.Driver;
import ua.bus.model.Route;
import ua.bus.utils.exceptions.NoRoutesFoundForCurrentDriverException;

import java.util.List;

/**
 * Created by Vitalii on 28.10.2017.
 */
@Service
public class DriverService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getRoutes(Driver driver) throws NoRoutesFoundForCurrentDriverException {
        List<Route> driversRoutes = routeRepository.findByDriver(driver);

        if(driversRoutes == null){
            throw new NoRoutesFoundForCurrentDriverException();
        }else
            return driversRoutes;
    }
}
