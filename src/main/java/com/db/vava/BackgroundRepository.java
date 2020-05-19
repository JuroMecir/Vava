package com.db.vava;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BackgroundRepository extends CrudRepository<Background, Integer> {

    @Query("select b.id from Background b")
    List<Integer> getAllIds();

    @Query("select b.name from Background b")
    List<String> getAllNames();

    @Query("select b from Background b where b.id = ?1")
    Background getById(Integer id);

}
