package com.db.vava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Integer> {

    // This return Race id by classId
    @Query("select s.id from Subclass s where s.classId = ?1")
    List<Integer> findIdsByClassId(Integer classId);

    // This return Race name by classId
    @Query("select s.name from Subclass s where s.classId = ?1")
    List<String> findNamesByClassId(Integer classId);

    // This return whole Race object with all features by id
    @Query("select s from Subclass s where s.id = ?1")
    Subclass getById(Integer id);

    @Query("select c.id from Subclass c")
    List<Integer> getAllIds();

    @Query("select c.name from Subclass c")
    List<String> getAllNames();

    @Query("select c.classId from Subclass c")
    List<Integer> getAllClassIds();

}