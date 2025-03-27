package com.mit.project.repository;

import com.mit.project.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

    //get filter data
    List<Tax> findByUserIdAndLandId(String userId, String landId);
    List<Tax> findByLandId(String landId);
    List<Tax> findByUserId(String userId);
}
