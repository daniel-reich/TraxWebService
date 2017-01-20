package traxWebService.entities;

/**
 * Created by Daniel on 1/19/17.
 */
public class TransitNetworkSummary {

    private String transitNetworkName;
    private String city;
    private int lines;
    private int stations;

    public String getTransitNetworkName() {
        return transitNetworkName;
    }

    public void setTransitNetworkName(String transitNetworkName) {
        this.transitNetworkName = transitNetworkName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getStations() {
        return stations;
    }

    public void setStations(int stations) {
        this.stations = stations;
    }
}
