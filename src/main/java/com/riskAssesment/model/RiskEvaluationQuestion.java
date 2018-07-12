package com.riskAssesment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Entity annotation. It is used to mark the class as a persistent Java class.
 * @Table annotation is used to provide the details of the table that this
 *        entity will be mapped to.
 * @author MP-29
 *
 */
@Entity
@Table(name = "risk_evaluation_question")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class RiskEvaluationQuestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
	  strategy = "uuid")
	private String id;

	@NotBlank
	@Column(unique=true)
	private String question;

	@ManyToOne
	@JoinColumn(name = "tierId", nullable = false)
	private RiskEvaluationTier riskEvaluationTier;
	
	@Column(columnDefinition="Decimal(10,2) default '0.00'")
	private double weight;


	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public RiskEvaluationTier getRiskEvaluationTier() {
		return riskEvaluationTier;
	}

	public void setRiskEvaluationTier(RiskEvaluationTier riskEvaluationTier) {
		this.riskEvaluationTier = riskEvaluationTier;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


}
