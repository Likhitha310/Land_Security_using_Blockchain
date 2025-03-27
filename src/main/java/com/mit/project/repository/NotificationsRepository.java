package com.mit.project.repository;


import com.mit.project.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByToIdOrderByIdDesc(String ToId);

    //find notifications which are public
    @Query(value = "SELECT * FROM notification WHERE category='ALL'",nativeQuery = true)
    List<Notification> findGeneral();

}

