package com.example.evstations.controllers;

import com.example.evstations.dto.EVStationDto;
import com.example.evstations.services.EVStationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EvStationController {
  @Autowired
  private EVStationService evStationService;

  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new EV station")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Successfully created the station")
  })
  public @ResponseBody ResponseEntity<EVStationDto> addEVStation(
      @RequestBody @Validated EVStationDto evStation
  ) {
    return new ResponseEntity<>(evStationService.addStation(evStation), HttpStatus.CREATED);
  }

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "List all EV Stations")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Listed all stations")
  })
  public @ResponseBody ResponseEntity<List<EVStationDto>> getAllEVStations() {
    return new ResponseEntity<>(evStationService.getAllStations(), HttpStatus.OK);
  }

  @GetMapping(value="/show/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get a station with id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Required station")
  })
  public @ResponseBody ResponseEntity<Optional<EVStationDto>> getEVStation(@PathVariable Integer id) {
    return new ResponseEntity<>(evStationService.getStationById(id), HttpStatus.OK);
  }

  @PutMapping(
      value = "{id}/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Edit a station with id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Edited station")
  })
  public @ResponseBody ResponseEntity<Optional<EVStationDto>> editEvStation(
      @PathVariable Integer id, @RequestBody @Validated EVStationDto evStation) {
    return new ResponseEntity<>(evStationService.updateStationById(id, evStation), HttpStatus.OK);
  }

  @PutMapping(
      value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Edit a station with id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Edited station")
  })
  public String editEvStation(
      @PathVariable Integer id) {
    evStationService.deleteStationById(id);
    return "Done";
  }
}
