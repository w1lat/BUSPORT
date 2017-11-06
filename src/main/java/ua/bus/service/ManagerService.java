package ua.bus.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.BusRepository;
import ua.bus.dao.RouteRepository;
import ua.bus.dao.StationRepository;
import ua.bus.model.Bus;
import ua.bus.model.Route;
import ua.bus.model.Station;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

@Service
public class ManagerService {

    private static Logger LOGGER = Logger.getLogger(ManagerService.class);

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private BusRepository busRepository;

//    public Map<String, Route> getRouteByDepartureAndStation(LocalDate dateOfDeparture, String stationName) throws NoSuchRouteException {
//        LOGGER.info("Starting find route procedure on " + dateOfDeparture + " and " + stationName + " station");
//        Map<String, Route> routes = routeRepository.findByStation(stationName);
//        if (routes.size() == 0) {
//            throw new NoSuchRouteException();
//        } else {
//            return routes;
//        }
//    }

    public Route addRoute(Route route) throws EntitySaveException {
        LOGGER.info("Starting new route adding");

        route = routeRepository.save(route);

        if (route == null) {
            throw new EntitySaveException(Route.class);
        } else return route;

    }

    public Bus addBus(Bus bus) throws EntitySaveException {
        LOGGER.info("Starting new bus adding");

        bus = busRepository.save(bus);

        if (bus == null) {
            throw new EntitySaveException(Bus.class);
        } else {
            return bus;
        }

    }

    public Station addStation(Station station) throws EntitySaveException {
        LOGGER.info("Starting station adding " + station.getStationName());

        Station saved = stationRepository.save(station);

        if (saved == null) {
            throw new EntitySaveException(Station.class);
        } else return saved;

    }

    public Iterable<Station> getAllStations() throws EntityNotFoundException {
        LOGGER.info("Starting all stations getting");
        Iterable stations = stationRepository.findAll();

        if (stations == null) {
            throw new EntityNotFoundException(0, Station.class); //0 means all stations
        } else {
            return stations;
        }
    }

    public Station getStationById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting station getting by id");
        Station station = stationRepository.findOne(id);

        if (station == null) {
            throw new EntityNotFoundException(id, Station.class);
        } else {
            return station;
        }

    }

    public Station updateStation(Station station) throws EntitySaveException {
        LOGGER.info("Starting station update");
        Station updatedStation = stationRepository.save(station);

        if (updatedStation == null) {
            throw new EntitySaveException(Station.class);
        } else {
            return updatedStation;
        }
    }

    public void deleteStation(long id) {
        LOGGER.info("Starting station delete");
        stationRepository.delete(id);
    }

    public Bus getBusById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting bus getting by id");
        Bus bus = busRepository.findOne(id);

        if (bus == null) {
            throw new EntityNotFoundException(id, Bus.class);
        } else {
            return bus;
        }
    }

    public Bus updateBus(Bus bus) throws EntitySaveException {
        LOGGER.info("Starting bus update");
        Bus updatedBus = busRepository.save(bus);

        if (updatedBus == null) {
            throw new EntitySaveException(Bus.class);
        } else {
            return updatedBus;
        }
    }

    public Iterable<Bus> getAllBuses() throws EntityNotFoundException {
        LOGGER.info("Starting all buses getting");
        Iterable buses = busRepository.findAll();

        if (buses == null) {
            throw new EntityNotFoundException(0, Bus.class); //0 means all busses
        } else {
            return buses;
        }
    }

    public void deleteBus(long id) {
        LOGGER.info("Starting bus delete");
        busRepository.delete(id);
    }

    public void deleteRoute(long id) {
        LOGGER.info("Starting route delete");
        routeRepository.delete(id);
    }

    public Iterable<Route> getAllRoutes() throws EntityNotFoundException {
        LOGGER.info("Starting all routes getting");
        Iterable routes = routeRepository.findAll();

        if (routes == null) {
            throw new EntityNotFoundException(0, Route.class); //0 means all routes
        } else {
            return routes;
        }
    }

    public Route updateRoute(Route route) throws EntitySaveException {
        LOGGER.info("Starting route update");
        Route updatedRoute = routeRepository.save(route);

        if (updatedRoute == null) {
            throw new EntitySaveException(Route.class);
        } else {
            return updatedRoute;
        }
    }

    public Route getRouteById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting route getting by id");
        Route route = routeRepository.findOne(id);

        if (route == null) {
            throw new EntityNotFoundException(id, Route.class);
        } else {
            return route;
        }
    }
}
