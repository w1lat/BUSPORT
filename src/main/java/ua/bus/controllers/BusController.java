package ua.bus.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bus.model.Bus;
import ua.bus.service.ManagerService;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

import javax.validation.Valid;

@Controller
public class BusController {

    private static final Logger LOGGER = Logger.getLogger(BusController.class);

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/addBus", method = RequestMethod.GET)
    public String newBus(ModelMap model) {
        Bus newBus = new Bus();
        model.addAttribute("bus", newBus);
        return "addBus";
    }

    @RequestMapping(value = {"/addBus"}, method = RequestMethod.POST)
    public String saveBus(@Valid Bus bus, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "addBus";
        }

        try {
            managerService.addBus(bus);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("success", "Bus " + bus.getModel() + " " + bus.getRegistryNumber() + " added successfully");
        //return "success";
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing driver.
     */
    @RequestMapping(value = {"/edit-bus-{id}"}, method = RequestMethod.GET)
    public String editBus(@PathVariable long id, ModelMap model) {
        Bus bus = null;
        try {
            bus = managerService.getBusById(id);
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        model.addAttribute("bus", bus);
        model.addAttribute("edit", true);
        return "addBus";
    }

    @RequestMapping(value = {"/edit-bus-{id}"}, method = RequestMethod.POST)
    public String updateDriver(@Valid Bus bus, BindingResult result,
                               ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "addBus";
        }
        try {
            managerService.updateBus(bus);
        } catch (EntitySaveException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("success", "Bus " + bus.getModel() + " " + bus.getRegistryNumber() + " updated successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = {"/allBuses"}, method = RequestMethod.GET)
    public String listDrivers(ModelMap model) {

        Iterable<Bus> buses = null;
        try {
            buses = managerService.getAllBuses();
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        model.addAttribute("buses", buses);
        return "listBuses";
    }

    /**
     * This method will delete bus by it's id value.
     */
    @RequestMapping(value = {"/delete-bus-{id}"}, method = RequestMethod.GET)
    public String deleteBus(@PathVariable long id) {
        managerService.deleteBus(id);
        return "redirect:/allBuses";
    }


}
