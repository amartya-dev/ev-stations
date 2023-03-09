package com.example.evstations.services;

import com.example.evstations.dto.EVStationDto;
import com.example.evstations.models.EVStation;
import com.example.evstations.repositories.EVStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EVStationService {
  @Autowired
  private EVStationRepository evStationRepository;

  public List<EVStationDto> getAllStations(Integer limit) {
    var stations = evStationRepository.findAll();
    return StreamSupport.stream(stations.spliterator(), false).map(
        station -> new EVStationDto(
            station.getStationId(),
            station.getStationName(),
            station.getStationImage(),
            station.getStationPricing(),
            station.getStationAddress()
        )
    ).collect(Collectors.toList());
  }

  public EVStationDto addStation(EVStationDto evStation) {
    var station = new EVStation();
    station.setStationId(evStation.getStationId());
    station.setStationName(evStation.getStationName());
    station.setStationImage(evStation.getStationImage());
    station.setStationPricing(evStation.getStationPricing());
    station.setStationAddress(evStation.getStationAddress());
    evStationRepository.save(station);
    return new EVStationDto(
        station.getStationId(),
        station.getStationName(),
        station.getStationImage(),
        station.getStationPricing(),
        station.getStationAddress()
    );
  }

  public Optional<EVStationDto> getStationById(Integer id) {
    return evStationRepository.findById(id).map(station -> new EVStationDto(
        station.getStationId(),
        station.getStationName(),
        station.getStationImage(),
        station.getStationPricing(),
        station.getStationAddress()
    ));
  }

  public Optional<EVStationDto> updateStationById(Integer id, EVStationDto evStation) {
    return  evStationRepository.findById(id).map(station -> {
      station.setStationName(evStation.getStationName());
      station.setStationImage(evStation.getStationImage());
      station.setStationPricing(evStation.getStationPricing());
      station.setStationAddress(evStation.getStationAddress());
      evStationRepository.save(station);
      return new EVStationDto(
          station.getStationId(),
          station.getStationName(),
          station.getStationImage(),
          station.getStationPricing(),
          station.getStationAddress()
      );
    });
  }

  public void deleteStationById(Integer id) {
    evStationRepository.deleteById(id);
  }
}
