package traxWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import traxWebService.entities.Station;
import traxWebService.entities.StationDAO;
import traxWebService.entities.TransitNetworkSummary;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class StartupDashboard {

    private final StationDAO stationDAO;


    @Autowired
    public StartupDashboard(StationDAO stationDAO) {

        Assert.notNull(stationDAO, "Station must not be null!");
        this.stationDAO = stationDAO;
    }

    @RequestMapping(value = "/")
    public String startDash(Model model) {
        Iterable<String> stations = stationDAO.findUniqueTransitNetworksAndCity();

        int i = 0;
        ArrayList<TransitNetworkSummary> transitNetworkList = new ArrayList<>();
        for(String station:stations) {
            TransitNetworkSummary networkSummary = new TransitNetworkSummary();
            networkSummary.setTransitNetworkName(station);
            networkSummary.setCity("Undetermined");
            networkSummary.setLines(stationDAO.countUniqueLines(station));
            networkSummary.setStations(stationDAO.countUniqueStations(station));
            transitNetworkList.add(networkSummary);
            i++;
        }

        model.addAttribute("transitNetworkList", transitNetworkList);



        return "startDash";
    }

    @RequestMapping(value = "addStation")
    public String addStation(){
        return "addStation";
    }

    @RequestMapping(value = "saveStation")
    public String saveStation(String city, double gps1, double gps2, String line, String stationAddress, String stationName, String transitNetworkName){
        Station station = new Station();
        station.setCity(city);
        station.setGps1(gps1);
        station.setGps2(gps2);
        station.setLine(line);
        station.setStationAddress(stationAddress);
        station.setStationName(stationName);
        station.setTransitNetworkName(transitNetworkName);
        stationDAO.save(station);
        return "addStation";
    }
}