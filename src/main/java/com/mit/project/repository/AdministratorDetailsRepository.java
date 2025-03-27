package com.mit.project.repository;

import com.mit.project.model.AdministratorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorDetailsRepository extends JpaRepository<AdministratorDetails,Long> {

    //get username and details

    AdministratorDetails findByUsernameAndPassword(String username, String password);
    List<AdministratorDetails> findByUsernameAndRole(String username, String role);
    List<AdministratorDetails> findByUsername(String username);
    List<AdministratorDetails> findByRole(String role);
}
