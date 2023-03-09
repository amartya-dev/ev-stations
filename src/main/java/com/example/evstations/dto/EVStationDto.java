package com.example.evstations.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.evstations.models.EVStation} entity
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EVStationDto implements Serializable {

  @JsonAlias("station_id")
  private final Integer stationId;

  @JsonAlias("station_name")
  private final String stationName;

  @JsonAlias("station_image")
  private final String stationImage;

  @JsonAlias("station_pricing")
  private final String stationPricing;

  @JsonAlias("station_address")
  private final String stationAddress;
}
