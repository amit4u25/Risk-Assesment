package com.riskAssesment.model;

import java.util.List;

/**
 * @Entity annotation. It is used to mark the class as a persistent Java class.
 * @Table annotation is used to provide the details of the table that this
 *        entity will be mapped to.
 * @author MP-29
 *
 */

public class AllQuestionAnswer {

	private String bap;
	private String releaseVersion;
	private List<QuestionAnswer> questionAnswer;

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

	public List<QuestionAnswer> getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(List<QuestionAnswer> questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

}
