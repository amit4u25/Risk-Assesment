package com.riskAssesment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riskAssesment.model.RiskEvaluation;

/**
 * 
 * @author MP-29 Spring Data JPA has got us covered here. It comes with a
 *         JpaRepository interface which defines methods for all the CRUD
 *         operations on the entity, and a default implementation of
 *         JpaRepository called SimpleJpaRepository.
 */
public interface RiskEvalutionRepository extends JpaRepository<RiskEvaluation, Long> {

	 
	
	@Query(value = "SELECT * FROM risk_evalution WHERE bap = ?1", nativeQuery = true)
	List<RiskEvaluation> findByBap(String bap);

}
