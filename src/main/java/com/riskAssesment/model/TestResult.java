package com.riskAssesment.model;

/**
 * @Entity annotation. It is used to mark the class as a persistent Java class.
 * @Table annotation is used to provide the details of the table that this
 *        entity will be mapped to.
 * @author MP-29
 *
 */

public class TestResult {

	private Boolean performanceTestingRequired;
	private String riskcategory;
	private double score;
	private String bap;
	private String releaseVersion;

	public Boolean getPerformanceTestingRequired() {
		return performanceTestingRequired;
	}

	public void setPerformanceTestingRequired(Boolean performanceTestingRequired) {
		this.performanceTestingRequired = performanceTestingRequired;
	}

	public String getRiskcategory() {
		return riskcategory;
	}

	public void setRiskcategory(String riskcategory) {
		this.riskcategory = riskcategory;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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
