package com.kapil.school.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "fee")
@Data
public class StudentFee implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1675331228092848572L;

	/**
	 *
	 */
	public StudentFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param amount
	 * @param createDateTime
	 * @param updateDateTime
	 * @param student
	 */
	public StudentFee(int id, double amount, LocalDateTime createDateTime, LocalDateTime updateDateTime,
			Student student) {
		super();
		this.id = id;
		this.amount = amount;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.student = student;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fee_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "amountReceived")
	private double amount;

	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

}