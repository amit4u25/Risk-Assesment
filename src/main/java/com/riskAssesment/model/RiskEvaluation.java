package com.riskAssesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

/**
 * @Entity annotation. It is used to mark the class as a persistent Java class.
 * @Table annotation is used to provide the details of the table that this
 *        entity will be mapped to.
 * @author MP-29
 *
 */
@Entity
@Table(name = "riskEvalution")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class RiskEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String bap;

	@NotBlank
	private String releaseVersion;

	@NotBlank
	private String riskAssesed;

	private Double riskScore;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRiskAssesed() {
		return riskAssesed;
	}

	public void setRiskAssesed(String riskAssesed) {
		this.riskAssesed = riskAssesed;
	}

	public Double getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Double riskScore) {
		this.riskScore = riskScore;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
