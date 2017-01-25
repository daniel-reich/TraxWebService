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
        String stationJson="{\"stations\":[";
        for(Station station: stations){
            stationJson = stationJson.concat("{");
            stationJson = stationJson.concat("\"station_id\":"+station.getStationId()+",");
            stationJson = stationJson.concat("\"station_name\":\""+station.getStationName()+"\",");
            stationJson = stationJson.concat("\"station_address\":\""+station.getStationAddress()+"\",");
            stationJson = stationJson.concat("\"station_line\":\""+station.getLine()+"\",");
            stationJson = stationJson.concat("\"lat1\":"+station.getLat1()+",");
            stationJson = stationJson.concat("\"long1\":"+station.getLong1()+",");
            stationJson = stationJson.concat("\"lat2\":"+station.getLat2()+",");
            stationJson = stationJson.concat("\"long2\":"+station.getLong2());
            stationJson = stationJson.concat("},");
            i++;
        }

        stationJson = stationJson.substring(0, stationJson.length()-1);
        stationJson = stationJson.concat("]}");

        return stationJson;
    }
}