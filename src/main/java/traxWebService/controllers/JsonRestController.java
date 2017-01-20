package traxWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traxWebService.entities.Station;
import traxWebService.entities.StationDAO;


@RestController
public class JsonRestController {

    private final StationDAO stationDAO;


    @Autowired
    public JsonRestController(StationDAO stationDAO) {

        Assert.notNull(stationDAO, "Station must not be null!");
        this.stationDAO = stationDAO;
    }

    @RequestMapping(value="/getData/")
    public String getTransitNetwork(String transitNetworkName){
        Iterable<Station> stations = stationDAO.findByTransitNetworkName(transitNetworkName);

        int i = 0;
        String csv="";
        for(Station station: stations){
            csv = csv.concat(station.getCity());
            csv = csv.concat(","+station.getGps1());
            csv = csv.concat(","+station.getGps2());
            csv = csv.concat(","+station.getLine());
            csv = csv.concat(","+station.getStationAddress());
            csv = csv.concat(","+station.getStationName());
            csv = csv.concat("<br>");
            i++;
        }

        return csv;
    }
}