package ua.bus.controllers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.bus.dao.RouteRepository;
import ua.bus.dao.StationRepository;
import ua.bus.model.Bus;
import ua.bus.model.Driver;
import ua.bus.model.Station;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InitAppContextTestBase {

    @Mock
    public RouteRepository routeRepository;
    @Mock
    public StationRepository stationRepository;

    protected Bus bus;
    protected Driver driver;
    protected Station station1;
    protected Station station2;

    @Before
    public  void setUpMocks(){
        bus = new Bus("bogdan", "BX3125AC", 40, 20.6F);
        driver = new Driver("Vasyl", "Petrenko", "Olehovych", LocalDate.of(1970, 12, 22).toString());
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
