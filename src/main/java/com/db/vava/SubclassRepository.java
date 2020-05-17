package com.db.vava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Integer> {

    List<Subclass> findAllByClassId(Integer classId);

}