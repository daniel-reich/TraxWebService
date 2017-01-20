package traxWebService.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@Transactional
public interface StationDAO extends CrudRepository<Station, Long> {

    List<Station> findByTransitNetworkName(String transitNetworkName);

    @Query(value="SELECT distinct transit_network_name FROM stations", nativeQuery = true)
    public List<String> findUniqueTransitNetworksAndCity();

    @Query(value="SELECT COUNT(distinct station_name) FROM stations WHERE transit_network_name = :transitNetworkName", nativeQuery = true)
    public int countUniqueStations(@Param("transitNetworkName") String transitNetworkName);

    @Query(value="SELECT COUNT(distinct line) FROM stations WHERE transit_network_name = :transitNetworkName", nativeQuery = true)
    public int countUniqueLines(@Param("transitNetworkName") String transitNetworkName);
}
