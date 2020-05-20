package com.db.vava;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called classRepository
// CRUD refers Create, Read, Update, Delete

public interface ClassRepository extends CrudRepository<Class, Integer> {

    @Query("select c.id from Class c")
    List<Integer> getAllIds();

    @Query("select c.name from Class c")
    List<String> getAllNames();

    // This return whole Class object with all features by id
    @Query("select c from Class c where c.id = ?1")
    Class getById(Integer id);

}