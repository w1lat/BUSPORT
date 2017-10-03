package ua.bus.service;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.bus.model.Driver;
import ua.bus.service.HRService;
import ua.bus.utils.exceptions.EntityNotFoundException;
import ua.bus.utils.exceptions.EntitySaveException;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HRServiceTest {

    @Autowired
    private HRService hrService;

    private Driver driver;

    @Before
    public void setUp(){
        driver = new Driver();

        driver.setName("Ivan");
        driver.setSurName("Ivanov");
        driver.setLastName("Ivanovich");
        driver.setBirthDay(LocalDate.of(1990, 10, 12));
    }

    @Test
    public void addNewDriverTest() throws EntitySaveException {
        Driver savedDriver = hrService.addDriver(driver);

        assertThat(savedDriver, is(driver));
    }

    @Test
    public void getDriverTest() throws EntitySaveException, EntityNotFoundException {
        Driver driver = hrService.getDriverById(3L);

        assertThat(driver.getName(), is("Ivan"));
    }
}
