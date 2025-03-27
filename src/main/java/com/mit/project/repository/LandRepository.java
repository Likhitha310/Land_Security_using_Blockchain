package com.mit.project.repository;

import com.mit.project.model.LandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandRepository extends JpaRepository<LandData, Long> {

    @Query(value = "select l.id from land_data l where l.district=:district and l.taluka=:taluka",nativeQuery = true)
    List<Long> findAllIdsByDistricAndTaluka(@Param("district") String district,@Param("taluka") String taluka);

    @Query(value = "select l.id from land_data l where l.user_id=:userId",nativeQuery = true)
    List<Long> findAllLands(@Param("userId") long userId);

}
