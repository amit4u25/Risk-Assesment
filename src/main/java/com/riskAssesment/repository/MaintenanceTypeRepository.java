package com.riskAssesment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.riskAssesment.model.MaintenanceType;

/**
 * 
 * @author MP-29 Spring Data JPA has got us covered here. It comes with a
 *         JpaRepository interface which defines methods for all the CRUD
 *         operations on the entity, and a default implementation of
 *         JpaRepository called SimpleJpaRepository.
 */
public interface MaintenanceTypeRepository extends PagingAndSortingRepository<MaintenanceType, Long> {

}
