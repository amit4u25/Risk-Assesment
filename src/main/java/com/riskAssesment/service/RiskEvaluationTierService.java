package com.riskAssesment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riskAssesment.model.RiskEvaluationTier;
import com.riskAssesment.repository.RiskEvaluationTierRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class RiskEvaluationTierService {

	@Autowired
	RiskEvaluationTierRepository riskEvaluationTierRepository;

	public RiskEvaluationTier createRiskEvaluationTier(RiskEvaluationTier riskEvaluationTier) {
		return riskEvaluationTierRepository.save(riskEvaluationTier);
	}

	/**
	 * getAllMaintenanceType() calls JpaRepository’s findAll() method to retrieve
	 * all the MaintenanceType from the database and returns the entire list.
	 * 
	 * @return List<MaintenanceType>
	 */
	public List<RiskEvaluationTier> getAllRiskEvaluationTier() {
		return riskEvaluationTierRepository.findAll();
	}

	public RiskEvaluationTier getById(Long id) {
		return riskEvaluationTierRepository.findOne(id);
	}

}
