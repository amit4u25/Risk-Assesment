package com.riskAssesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riskAssesment.model.TierThreeQuestion;;

/**
 * 
 * @author MP-29 Spring Data JPA has got us covered here. It comes with a
 *         JpaRepository interface which defines methods for all the CRUD
 *         operations on the entity, and a default implementation of
 *         JpaRepository called SimpleJpaRepository.
 */
public interface TierThreeQuestionRepository extends JpaRepository<TierThreeQuestion, Long> {
	@Query(value = "SELECT * FROM tier_three_question WHERE id = ?", nativeQuery = true)
	TierThreeQuestion findOne(String questionId);

}
