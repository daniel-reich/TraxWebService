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
    private double lat1;

    @NotNull
    private double long1;
    
    @NotNull
    private double lat2;
    
    @NotNull
    private double long2;

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

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public double getLong1() {
        return long1;
    }

    public void setLong1(double long1) {
        this.long1 = long1;
    }

    public double getLat2() {
        return lat2;
    }

    public void setLat2(double lat2) {
        this.lat2 = lat2;
    }

    public double getLong2() {
        return long2;
    }

    public void setLong2(double long2) {
        this.long2 = long2;
    }
}
