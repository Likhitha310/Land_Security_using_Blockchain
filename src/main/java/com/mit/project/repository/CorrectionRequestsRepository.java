package com.mit.project.repository;

import com.mit.project.model.CorrectionRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrectionRequestsRepository extends JpaRepository<CorrectionRequests, Long> {

    //For reccord tables
    @Query(value = "SELECT id, owner_id, land_id, details, timestamp, completed FROM correction_requests cr WHERE cr.completed=false",nativeQuery = true)
    List<Object[]> findAllRecords();

    @Query(value = "SELECT id, owner_id, land_id, details, timestamp, completed FROM correction_requests cr WHERE cr.land_id= :landId",nativeQuery = true)
    List<Object[]> findByLandId(String landId);

    @Query(value = "SELECT id, owner_id, land_id, details, timestamp, completed FROM correction_requests cr WHERE cr.id= :id",nativeQuery = true)
    List<Object[]> findRecordById(long id);

}
