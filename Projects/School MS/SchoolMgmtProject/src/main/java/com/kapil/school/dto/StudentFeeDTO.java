package com.kapil.school.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentFeeDTO implements Serializable {

	/**
	 *
	 */
	public StudentFeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param amount
	 * @param createDateTime
	 * @param updateDateTime
	 * @param studentDTO
	 */
	public StudentFeeDTO(int id, double amount, LocalDateTime createDateTime, LocalDateTime updateDateTime,
			StudentDTO studentDTO) {
		super();
		this.id = id;
		this.amount = amount;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.studentDTO = studentDTO;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 252807018591967997L;

	private int id;

	private double amount;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

	private StudentDTO studentDTO;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the createDateTime
	 */
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the student
	 */
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}
}
