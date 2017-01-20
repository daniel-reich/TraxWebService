package traxWebService.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STATIONS")
public class Station {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stationId;

    @NotNull
    private String city;
    @NotNull
    private String transitNetworkName;

    private String line;

    @NotNull
    private String stationName;

    @NotNull
    private String stationAddress;

    @NotNull
    private double gps1;

    @NotNull
    private double gps2;

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTransitNetworkName() {
        return transitNetworkName;
    }

    public void setTransitNetworkName(String transitNetworkName) {
        this.transitNetworkName = transitNetworkName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public double getGps1() {
        return gps1;
    }

    public void setGps1(double gps1) {
        this.gps1 = gps1;
    }

    public double getGps2() {
        return gps2;
    }

    public void setGps2(double gps2) {
        this.gps2 = gps2;
    }
}
