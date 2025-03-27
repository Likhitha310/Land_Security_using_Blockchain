package com.mit.project.repository;

import com.mit.project.model.TransactionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRequestRepository extends JpaRepository<TransactionRequest,Long> {
//    long countByName(String name);
}
