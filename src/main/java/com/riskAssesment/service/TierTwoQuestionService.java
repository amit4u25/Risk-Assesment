package com.riskAssesment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riskAssesment.model.TierTwoQuestion;
import com.riskAssesment.repository.TierTwoQuestionRepository;

/**
 * 
 * @author MP-29
 *
 */
@Component
public class TierTwoQuestionService {

	@Autowired
	TierTwoQuestionRepository tierTwoQuestionRepository;

	public TierTwoQuestion createQuestion(TierTwoQuestion tierTwoQuestion) {
		return tierTwoQuestionRepository.save(tierTwoQuestion);
	}

//	/**
//	 * getAllMaintenanceType() calls JpaRepository’s findAll() method to retrieve
//	 * all the MaintenanceType from the database and returns the entire list.
//	 * 
//	 * @return List<MaintenanceType>
//	 */
//	public List<MaintenanceType> getAllMaintenanceType() {
//		return maintenanceTypeRepository.findAll();
//	}

}
