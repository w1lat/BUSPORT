package ua.bus.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ua.bus.dao.RouteRepository;
import ua.bus.dao.StationRepository;
import ua.bus.model.Bus;
import ua.bus.model.Driver;
import ua.bus.model.Station;

import java.math.BigDecimal;
import java.time.LocalDate;

//@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class InitAppContextTestBase {

    @Mock
    public RouteRepository routeRepository;
    @Mock
    public StationRepository stationRepository;

    protected Bus bus;
    protected Driver driver;
    protected Station station1;
    protected Station station2;

    @BeforeEach
    public void setUpMocks() {
        bus = new Bus("bogdan", "BX3125AC", 40, new BigDecimal(20.6));
        driver = Driver.builder().name("Vasyl").surName("Petrenko").lastName("Olehovych").birthDay(LocalDate.of(1970, 12, 22)).build();
        station1 = new Station("km1", "Khmelnytskyi Center");
        station2 = new Station("kv1", "Kyiv Central Railway");


//        try {
//            when(routeRepository.getPlayerById(1)).thenReturn(new Player(1, 6000));
//            when(playerDao.getPlayerById(40)).thenThrow(NoSuchPlayerException.class);
//        } catch (NoSuchPlayerException e) {
//            e.printStackTrace();
//        }
//
//        playerService = new PlayerServiceImpl(playerDao,transactionDao);
//
//        when(playerService.findAll()).thenReturn(Arrays.asList(new Player(1, 6000), new Player(2, 55555)));
//
//        deckService = new DeckService();
//
//        gameManager = new GameManager(playerService,deckService);


    }
}
