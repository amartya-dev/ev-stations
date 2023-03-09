package com.example.evstations.repositories;

import com.example.evstations.models.EVStation;
import org.springframework.data.repository.CrudRepository;

public interface EVStationRepository extends CrudRepository<EVStation, Integer> {
}
