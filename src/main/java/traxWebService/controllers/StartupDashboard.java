package traxWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import traxWebService.entities.Station;
import traxWebService.entities.StationDAO;
import traxWebService.entities.TransitNetworkSummary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        for (String station : stations) {
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
    public String addStation() {
        return "addStation";
    }

    @RequestMapping(value = "saveStation")
    public String saveStation(String city, double lat1, double long1, double long2, double lat2, String line, String stationAddress, String stationName, String transitNetworkName) {
        Station station = new Station();
        station.setCity(city);
        station.setLat1(lat1);
        station.setLong1(long1);
        station.setLat2(lat2);
        station.setLong2(long2);
        station.setLine(line);
        station.setStationAddress(stationAddress);
        station.setStationName(stationName);
        station.setTransitNetworkName(transitNetworkName);
        stationDAO.save(station);
        return "addStation";
    }

    @RequestMapping(value = "viewTransitNetwork")
    public String saveStation(String transitNetworkName, Model model) {
        Iterable<Station> stations = stationDAO.findByTransitNetworkName(transitNetworkName);
        model.addAttribute("stations", stations);
        return "viewTransitNetwork";
    }

    @RequestMapping(value = "goToUploader")
    public String goToUploader() {
        return "csvInput";
    }


    @RequestMapping(value = "uploadStationData")
    public View uploadData(MultipartFile csvFile) {

        try (InputStream inputStream = csvFile.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String stringLine;

            //Get the headers of csv (must be on 1st line)
            String[] headers = bufferedReader.readLine().split(",");


            //Find the order the csv columns are in
            int i = 0;
            //int stationIdPlace = 0;
            int cityPlace = 0;
            int linePlace = 0;
            int stationAddressPlace = 0;
            int stationNamePlace = 0;
            int transitNetworkNamePlace = 0;
            int lat1Place = 0;
            int long1Place = 0;
            int lat2Place = 0;
            int long2Place = 0;

            for (String word : headers) {
                //if (word.equalsIgnoreCase("Station id") || word.equalsIgnoreCase("stationid") || word.equalsIgnoreCase("station_id")){
                //  stationIdPlace = i;
                if (word.equalsIgnoreCase("city")) {
                    cityPlace = i;
                } else if (word.equalsIgnoreCase("line")) {
                    linePlace = i;
                } else if (word.equalsIgnoreCase("stationName") || word.equalsIgnoreCase("station name")) {
                    stationNamePlace = i;
                } else if (word.equalsIgnoreCase("stationAddress") || word.equalsIgnoreCase("station Address")) {
                    stationAddressPlace = i;
                } else if (word.equalsIgnoreCase("transit network name") || word.equalsIgnoreCase("transitnetwork name") || word.equalsIgnoreCase("transit name")) {
                    transitNetworkNamePlace = i;
                } else if (word.equalsIgnoreCase("lat1")) {
                    lat1Place = i;
                } else if (word.equalsIgnoreCase("long1")) {
                    long1Place = i;
                } else if (word.equalsIgnoreCase("lat2")) {
                    lat2Place = i;
                } else if (word.equalsIgnoreCase("long2")) {
                    long2Place = i;
                }
                i++;
            }

            //for each line, find the item in the main inventory database and update its fields
            while ((stringLine = bufferedReader.readLine()) != null) {
                String[] line = stringLine.split(",");

                Station newStation = new Station();
                newStation.setCity(line[cityPlace]);
                newStation.setLine(line[linePlace]);
                newStation.setStationName(line[stationNamePlace]);
                newStation.setStationAddress(line[stationAddressPlace]);
                newStation.setTransitNetworkName(line[transitNetworkNamePlace]);
                newStation.setLat1(Double.parseDouble(line[lat1Place]));
                newStation.setLong1(Double.parseDouble(line[long1Place]));
                newStation.setLat2(Double.parseDouble(line[lat2Place]));
                newStation.setLong2(Double.parseDouble(line[long2Place]));

                stationDAO.save(newStation);
            }
        } catch (IOException e) {

        }
        return new RedirectView("/");
    }

}