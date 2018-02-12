package com.riskAssesment.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Entity annotation. It is used to mark the class as a persistent Java class.
 * @Table annotation is used to provide the details of the table that this
 *        entity will be mapped to.
 * @author MP-29
 *
 */

public class AllQuestionAnswer {

	private Long questionId;

	private Boolean answer;
	
	private String bap;

	private String releaseVersion;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Boolean getAnswer() {
		return answer;
	}

	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}

	public String getBap() {
		return bap;
	}

	public void setBap(String bap) {
		this.bap = bap;
	}

	public String getReleaseVersion() {
		return releaseVersion;
	}

	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}
}
