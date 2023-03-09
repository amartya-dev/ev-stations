package com.example.evstations.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class EVStation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter @Setter
  private Integer stationId;

  @Getter @Setter
  private String stationName;

  @Getter @Setter
  private String stationImage;

  @Getter @Setter
  private String stationPricing;

  @Getter @Setter
  private String stationAddress;
}
