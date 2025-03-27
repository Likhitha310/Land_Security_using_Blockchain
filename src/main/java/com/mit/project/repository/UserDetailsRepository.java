package com.mit.project.repository;

import com.mit.project.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByUsernameAndPassword(String username,String password);

}
