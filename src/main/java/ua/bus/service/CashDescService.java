package ua.bus.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.RouteRepository;
import ua.bus.utils.exceptions.NoSuchRouteException;
import ua.bus.model.Route;
import ua.bus.model.Ticket;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class CashDescService {

    private static final Logger LOGGER = Logger.getLogger(CashDescService.class);

    private RouteRepository routeRepository;

    @Autowired
    public CashDescService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    public Map<String, Route> findRoute(LocalDate dateOfDeparture, String stationName) throws NoSuchRouteException {
//        LOGGER.info("Starting find route procedure on " + dateOfDeparture + " and " + stationName + " station");
//        Map<String, Route> routes = routeRepository.findByDateAndStation(dateOfDeparture, stationName);
//        if (routes.size() == 0){
//            throw new NoSuchRouteException();
//        }else {
            return new HashMap<String, Route>();
//        }
    }

    public Ticket buyTicketProcudure(){
        return null;
    }
}
