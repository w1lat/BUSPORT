package ua.bus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ua.bus.dao.BusRepository;
import ua.bus.dao.RouteRepository;
import ua.bus.dao.StationRepository;
import ua.bus.dao.WayPointRepository;
import ua.bus.model.Bus;
import ua.bus.model.Route;
import ua.bus.model.Station;
import ua.bus.model.WayPoint;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

@Service
public class ManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private WayPointRepository wayPointRepository;

//    public Map<String, Route> getRouteByDepartureAndStation(LocalDate dateOfDeparture, String stationName) throws NoSuchRouteException {
//        LOGGER.info("Starting find route procedure on " + dateOfDeparture + " and " + stationName + " station");
//        Map<String, Route> routes = routeRepository.findByStation(stationName);
//        if (routes.size() == 0) {
//            throw new NoSuchRouteException();
//        } else {
//            return routes;
//        }
//    }

    public Route addNewRoute(Route route) throws EntitySaveException {
        LOGGER.info("Starting new route adding" + route.toString());

        // Ensure bidirectional relationship is set
        for (WayPoint wayPoint : route.getWayPoints()) {
            wayPoint.setRoute(route);
        }

        Station departureStation = route.getWayPoints().getFirst().getStation();
        if(departureStation.getStationCode() == null) {
            departureStation = stationRepository.findById(departureStation.getId()).orElseThrow(() -> new IllegalArgumentException("Departure Station not found"));
        }

        Station arrivalStation = route.getWayPoints().getLast().getStation();
        if(arrivalStation.getStationCode() == null) {
            arrivalStation = stationRepository.findById(arrivalStation.getId()).orElseThrow(() -> new IllegalArgumentException("Arrival Station not found"));
        }

        route.generateRouteCode(departureStation.getStationCode(), arrivalStation.getStationCode());

        try {
            return routeRepository.save(route);
        } catch (DataAccessException e) {
            throw new EntitySaveException(Route.class);
        }

    }

    public Bus addNewBus(Bus bus) throws EntitySaveException {
        LOGGER.info("Starting new bus adding" + bus.toString());

        try {
            return busRepository.save(bus);
        } catch (DataAccessException e) {
            throw new EntitySaveException(Bus.class);
        }

    }

    public Station addNewStation(Station station) throws EntitySaveException {
        LOGGER.info("Starting station adding " + station.toString());

        try {
            return stationRepository.save(station);
        } catch (DataAccessException e){
            throw new EntitySaveException(Station.class);
        }

    }

    public Iterable<Station> getAllStations() throws EntityNotFoundException {
        LOGGER.info("Starting all stations getting");
        try {
            return  stationRepository.findAll();
        }catch (DataAccessException e){
            throw new EntityNotFoundException(0, Station.class); //0 means all stations
        }
    }

    public Station getStationById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting station getting by id" + id);

        return stationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Station.class));
    }

    public Station updateStation(Station station) throws EntitySaveException {
        LOGGER.info("Starting station update" + station.toString());

        try {
            return stationRepository.save(station);
        }catch (DataAccessException e){
            throw new EntitySaveException(Station.class);
        }
    }

    public void deleteStation(long id) {
        LOGGER.info("Starting station delete" + id);
        stationRepository.deleteById(id);
    }

    public Bus getBusById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting bus getting by id" + id);

        return busRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Bus.class));
    }

    public Bus updateBus(Bus bus) throws EntitySaveException {
        LOGGER.info("Starting bus update" + bus.toString());

        try {
            return busRepository.save(bus);
        }catch (DataAccessException e){
            throw new EntitySaveException(Bus.class);
        }
    }

    public Iterable<Bus> getAllBuses() throws EntityNotFoundException {
        LOGGER.info("Starting all buses getting");

        try {
            return busRepository.findAll();
        }catch (DataAccessException e){
            throw new EntityNotFoundException(0, Bus.class); //0 means all busses
        }
    }

    public void deleteBus(long id) {
        LOGGER.info("Starting bus delete" + id);
        busRepository.deleteById(id);
    }

    public void deleteRoute(long id) {
        LOGGER.info("Starting route delete" + id);
        routeRepository.deleteById(id);
    }

    public Iterable<Route> getAllRoutes() throws EntityNotFoundException {
        LOGGER.info("Starting all routes getting");

        try {
            return routeRepository.findAll();
        }catch (DataAccessException e){
            throw new EntityNotFoundException(0, Route.class); //0 means all routes
        }
    }

    public Route updateRoute(Route route) throws EntitySaveException {
        LOGGER.info("Starting route update" + route.toString());

        try {
            return routeRepository.save(route);
        } catch (DataAccessException e){
            throw new EntitySaveException(Route.class);
        }
    }

    public Route getRouteById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting route getting by id" + id);
        return routeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Route.class));
    }

    public WayPoint getWayPointById(long id) throws EntityNotFoundException {
        LOGGER.info("Starting waypoint getting by id" + id);
        return wayPointRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Route.class));
    }
}
