package ua.bus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.bus.dao.DriverRepository;
import ua.bus.model.Driver;
import ua.bus.service.HRService;
import ua.bus.utils.exceptions.DriverSaveException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@Controller
public class AddNewDriverController {

    @Autowired
    private HRService hrService;

    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping(value = "/addDriver", method = RequestMethod.GET)
    public String addDriver(ModelMap model) {
        Driver newDriver = new Driver();
        model.addAttribute("driver", newDriver);
        return "addDriver";
    }

    @RequestMapping(value = { "/addDriver" }, method = RequestMethod.POST)
    public String saveUser(@Valid Driver driver, ModelMap model) {
		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
		 * and applying it on field [sso] of Model class [User].
		 *
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 *
		 */
        try {
            driver.setBirthDay(LocalDate.of(1990, Month.FEBRUARY, 21));
            hrService.addDriver(driver);
        } catch (DriverSaveException e) {
            e.printStackTrace();
        }

        model.addAttribute("success", "Driver " + driver.getName() + " "+ driver.getLastName() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        Iterable<Driver> drivers = driverRepository.findAll();
        model.addAttribute("drivers", drivers);
        return "listDrivers";
    }


}
