package com.riskAssesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riskAssesment.model.TierTwoQuestion;;

/**
 * 
 * @author MP-29 Spring Data JPA has got us covered here. It comes with a
 *         JpaRepository interface which defines methods for all the CRUD
 *         operations on the entity, and a default implementation of
 *         JpaRepository called SimpleJpaRepository.
 */
public interface TierTwoQuestionRepository extends JpaRepository<TierTwoQuestion, Long> {

}
