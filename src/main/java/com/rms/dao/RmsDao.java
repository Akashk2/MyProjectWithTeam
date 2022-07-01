package com.rms.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.model.CandidatesDetails;

@Repository
public interface RmsDao extends JpaRepository<CandidatesDetails, Integer> {

	@Query(value = "SELECT * FROM candidates_details WHERE month(last_updated_on)=month(now())", nativeQuery = true)
	Collection<CandidatesDetails> countCandidateUpdatedInOneWeek();
	
	@Query(value = "SELECT * FROM candidates_details WHERE last_updated_on<now() - interval 1 month-1", nativeQuery = true)
	Collection<CandidatesDetails> countCandidateUpdatedInOneMonth();
	
	@Query(value = "select * from candidates_details where last_updated_on < DATE_SUB(NOW(),INTERVAL 1 YEAR);", nativeQuery = true)
	Collection<CandidatesDetails> countCandidateUpdatedInOneYear();
	
	@Query(value = "select * from candidates_details", nativeQuery = true)
	Collection<CandidatesDetails> getTotalres();
	
	@Query(value = "SELECT * FROM candidates_details WHERE uploaded_by='REC'", nativeQuery = true)
	Collection<CandidatesDetails> newUploadsByRecuiter();
	@Query(value = "SELECT * FROM candidates_details WHERE uploaded_by='CAN'", nativeQuery = true)
	Collection<CandidatesDetails> newUploadsByCandidate();
	@Query(value = "SELECT * FROM candidates_details WHERE status='INACTIVE'", nativeQuery = true)
	Collection<CandidatesDetails> resumeDeactivated();
}
