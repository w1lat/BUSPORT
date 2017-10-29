package ua.bus.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bus.model.Bus;
import ua.bus.model.Driver;
import ua.bus.model.Route;
import ua.bus.model.Station;
import ua.bus.service.HRService;
import ua.bus.service.ManagerService;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Vitalii on 28.10.2017.
 */
@Controller
public class RouteController {

    private static final Logger LOGGER = Logger.getLogger(RouteController.class);

    @Autowired
    private ManagerService managerService;
    @Autowired
    private HRService hrService;

    @RequestMapping(value = "/addRoute", method = RequestMethod.GET)
    public String newRoute(ModelMap model){
        Route route = new Route();
        Iterable<Driver> drivers = null;
        Iterable<Station> stations = null;
        Iterable<Bus> buses = null;
        try {
            drivers = hrService.getAllDrivers();
            stations = managerService.getAllStations();
            buses = managerService.getAllBuses();

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        model.addAttribute("route", route);
        model.addAttribute("driverList", drivers);
        model.addAttribute("stationList", stations);
        model.addAttribute("busList", buses);

        return "addRoute";
    }

    @RequestMapping(value = "addRoute", method = RequestMethod.POST)
    public String saveRoute(@Valid Route route, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return "addRoute";
        }
        try{
            route.generateRouteCode();

            managerService.addRoute(route);
        } catch (EntitySaveException e) {
            e.printStackTrace();
        }
        return "registrationsuccess";
    }
}
