package ua.bus.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bus.model.Station;
import ua.bus.service.ManagerService;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

import javax.validation.Valid;

@Controller
public class StationController {

    private static final Logger LOGGER = Logger.getLogger(StationController.class);

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/addStation", method = RequestMethod.GET)
    public String newStation(ModelMap model) {
        Station newStation = new Station();
//        Coordinates stationCoordinates = new Coordinates();
        model.addAttribute("station", newStation);
//        model.addAttribute("coord", stationCoordinates);
        return "addStation";
    }

    @RequestMapping(value = {"/addStation"}, method = RequestMethod.POST)
    public String saveStation(@Valid Station station,
                              BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "addStation";
        }

        try {
//            station.setCoordinates(coordinates);
            station.setRoutes(null);
            managerService.addStation(station);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("success", "Station " + station.getStationName() + " added successfully");
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing driver.
     */
    @RequestMapping(value = {"/edit-station-{id}"}, method = RequestMethod.GET)
    public String editStation(@PathVariable long id, ModelMap model) {
        Station station = null;
        try {
            station = managerService.getStationById(id);
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("station", station);
        model.addAttribute("edit", true);
        return "addStation";
    }

    @RequestMapping(value = {"/edit-station-{id}"}, method = RequestMethod.POST)
    public String updateRoute(@Valid Station station, BindingResult result,
                               ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "addStation";
        }
        try {
            managerService.updateStation(station);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("success", "Station " + station.getStationName() + " updated successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/allStations"}, method = RequestMethod.GET)
    public String listStations(ModelMap model) {

        Iterable<Station> stations = null;
        try {
            stations = managerService.getAllStations();
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("stations", stations);
        return "listStations";
    }

    /**
     * This method will delete driver by it's id value.
     */
    @RequestMapping(value = {"/delete-station-{id}"}, method = RequestMethod.GET)
    public String deleteStation(@PathVariable long id) {
        managerService.deleteStation(id);
        return "redirect:/allStations";
    }


}
