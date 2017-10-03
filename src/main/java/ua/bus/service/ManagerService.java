package ua.bus.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.bus.dao.StationRepository;
import ua.bus.model.Station;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

@Service
public class ManagerService {

    private static Logger LOGGER = Logger.getLogger(ManagerService.class);

//    @Autowired
//    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;

//    public Map<String, Route> getRouteByDepartureAndStation(LocalDate dateOfDeparture, String stationName) throws NoSuchRouteException {
//        LOGGER.info("Starting find route procedure on " + dateOfDeparture + " and " + stationName + " station");
//        Map<String, Route> routes = routeRepository.findByStation(stationName);
//        if (routes.size() == 0) {
//            throw new NoSuchRouteException();
//        } else {
//            return routes;
//        }
//    }

//    public Route addRoute(Driver driver, Bus bus, Station... stations) throws EntitySaveException {
//        LOGGER.info("Starting new route adding");
//        Route route = new Route();
//        route.setBus(bus);
//        route.setDriver(driver);
//        route.setStations(IntStream.range(0, Arrays.asList(stations).size())
//                .boxed()
//                .collect(Collectors.toMap(i -> i, i -> Arrays.asList(stations).get(i))));
//        route.generateRouteCode();
//        route = routeRepository.save(route);
//
//        if (route == null) {
//            throw new EntitySaveException(Route.class);
//        } else return route;
//
//    }

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

        if(station == null){
            throw new EntityNotFoundException(id, Station.class);
        }else{
            return station;
        }

    }

    public Station updateStation(Station station) throws EntitySaveException {
        LOGGER.info("Starting station update");
        Station updatedStation = stationRepository.save(station);

        if(updatedStation == null){
            throw new EntitySaveException(Station.class);
        }else{
            return updatedStation;
        }
    }

    public void deleteStation(long id) {
        LOGGER.info("Starting station delete");
        stationRepository.delete(id);
    }
}
