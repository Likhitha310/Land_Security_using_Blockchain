package com.mit.project.repository;

import com.mit.project.model.OwnedLand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnedLandsRepository extends JpaRepository<OwnedLand,String> {

    List<OwnedLand> findByOwnerId(String ownerId);

    @Modifying
    @Query(value = "delete from owned_lands where owner_id = :ownerId",nativeQuery = true)
    void deleteByOwnerId(String ownerId);
}
