package com.db.vava;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called raceRepository
// CRUD refers Create, Read, Update, Delete

public interface RaceRepository extends CrudRepository<Race, Integer> {

    @Query("select r.id from Race r")
    List<Integer> getAllIds();

    @Query("select r.name from Race r")
    List<String> getAllNames();

    // This return whole Race object with all features by id
    @Query("select r from Race r where r.id = ?1")
    Race getById(Integer id);

}