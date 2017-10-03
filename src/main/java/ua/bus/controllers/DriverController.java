package ua.bus.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bus.model.Driver;
import ua.bus.service.HRService;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

import javax.validation.Valid;

@Controller
public class DriverController {

    private static final Logger LOGGER = Logger.getLogger(DriverController.class);

    @Autowired
    private HRService hrService;

    @RequestMapping(value = "/addDriver", method = RequestMethod.GET)
    public String newDriver(ModelMap model) {
        Driver newDriver = new Driver();
        model.addAttribute("driver", newDriver);
        return "addDriver";
    }

    @RequestMapping(value = {"/addDriver"}, method = RequestMethod.POST)
    public String saveDriver(@Valid Driver driver, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "addDriver";
        }

        try {
            hrService.addDriver(driver);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("success", "Driver " + driver.getName() + " " + driver.getLastName() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing driver.
     */
    @RequestMapping(value = {"/edit-driver-{id}"}, method = RequestMethod.GET)
    public String editDriver(@PathVariable long id, ModelMap model) {
        Driver driver = null;
        try {
            driver = hrService.getDriverById(id);
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("driver", driver);
        model.addAttribute("edit", true);
        return "addDriver";
    }

    @RequestMapping(value = {"/edit-driver-{id}"}, method = RequestMethod.POST)
    public String updateDriver(@Valid Driver driver, BindingResult result,
                               ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "addDriver";
        }
        try {
            hrService.updateDriver(driver);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("success", "Driver " + driver.getName() + " " + driver.getSurName() + " updated successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/allDrivers"}, method = RequestMethod.GET)
    public String listDrivers(ModelMap model) {

        Iterable<Driver> drivers = null;
        try {
            drivers = hrService.getAllDrivers();
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("drivers", drivers);
        return "listDrivers";
    }

    /**
     * This method will delete driver by it's id value.
     */
    @RequestMapping(value = {"/delete-driver-{id}"}, method = RequestMethod.GET)
    public String deleteDriver(@PathVariable long id) {
        hrService.deleteDriver(id);
        return "redirect:/allDrivers";
    }


}
