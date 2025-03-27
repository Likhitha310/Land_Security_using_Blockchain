package com.mit.project.repository;

import com.mit.project.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    //get filter data
    List<Loan> findByUserIdAndLandId(String userId, String landId);
    List<Loan> findByLandId(String landId);
    List<Loan> findByUserId(String userId);

    /*@Query("SELECT l FROM Loan l WHERE (l.userId = :userId) and (l.landId = :landId)")
    @Query("SELECT l FROM Loan l WHERE l.userId = :userId")
    @Query("SELECT l FROM Loan l WHERE l.landId = :landId")*/
}
