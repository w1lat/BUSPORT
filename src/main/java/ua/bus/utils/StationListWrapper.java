package ua.bus.utils;

import ua.bus.model.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii on 28.01.2019.
 */
public class StationListWrapper {
        private List<Station> stationList;

//        public StationListWrapper() {
//            this.stationList = new ArrayList<Station>();
//        }

        public List<Station> getStationList() {
            return stationList;
        }

        public void setStationList(List<Station> stationList) {
            this.stationList = stationList;
        }
}
