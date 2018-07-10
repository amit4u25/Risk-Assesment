package com.riskAssesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.riskAssesment.model.MaintenanceType;
import com.riskAssesment.repository.MaintenanceTypeRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class MaintenanceTypeService {

	@Autowired
	MaintenanceTypeRepository maintenanceTypeRepository;

	public MaintenanceType createMaintenanceType(MaintenanceType maintenanceType) {
		return maintenanceTypeRepository.save(maintenanceType);
	}

	/**
	 * getAllMaintenanceType() calls JpaRepository’s findAll() method to retrieve
	 * all the MaintenanceType from the database and returns the entire list.
	 * 
	 * @return List<MaintenanceType>
	 */
	public List<MaintenanceType> getAllMaintenanceType() {

		Sort sort = new Sort(Sort.Direction.ASC, "changeType");

		return (List<MaintenanceType>) maintenanceTypeRepository.findAll(sort);
		// return maintenanceTypeRepository.findAll(Sort.Direction.ASC,
		// "id").getContent();
	}

	public MaintenanceType getById(Long id) {
		return maintenanceTypeRepository.findOne(id);
	}

}
