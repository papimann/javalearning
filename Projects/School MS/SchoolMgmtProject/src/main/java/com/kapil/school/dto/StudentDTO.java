package com.kapil.school.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.validator.constraints.Range;

public class StudentDTO implements Serializable {

	/**
	 *
	 */
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 252807018591967997L;

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param mobile
	 * @param lastName
	 * @param firstName
	 * @param fatherName
	 * @param motherName
	 * @param aadhaarNumber
	 * @param panCard
	 * @param admissionDate
	 * @param relievingDate
	 * @param monthlyFee
	 * @param createDateTime
	 * @param updateDateTime
	 */
	public StudentDTO(int id, String name, String email, int mobile, String lastName, String firstName,
			String fatherName, String motherName, int aadhaarNumber, String panCard, LocalDate admissionDate,
			LocalDate relievingDate, Double monthlyFee, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.lastName = lastName;
		this.firstName = firstName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.aadhaarNumber = aadhaarNumber;
		this.panCard = panCard;
		this.admissionDate = admissionDate;
		this.relievingDate = relievingDate;
		this.monthlyFee = monthlyFee;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	private int id;

	private String name;

	private String email;

	@Range(min = 10, max = 10)
	private int mobile;

	private String lastName;

	private String firstName;

	private String fatherName;

	private String motherName;

	@Range(min = 12, max = 12)
	private int aadhaarNumber;

	private String panCard;

	private LocalDate admissionDate;

	private LocalDate relievingDate;

	private Double monthlyFee;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public int getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the aadhaarNumber
	 */
	public int getAadhaarNumber() {
		return aadhaarNumber;
	}

	/**
	 * @param aadhaarNumber the aadhaarNumber to set
	 */
	public void setAadhaarNumber(int aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	/**
	 * @return the panCard
	 */
	public String getPanCard() {
		return panCard;
	}

	/**
	 * @param panCard the panCard to set
	 */
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	/**
	 * @return the admissionDate
	 */
	public Optional<LocalDate> getAdmissionDate() {
		return Optional.ofNullable(admissionDate);
	}

	/**
	 * @param admissionDate the admissionDate to set
	 */
	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the relievingDate
	 */
	public Optional<LocalDate> getRelievingDate() {
		return Optional.ofNullable(relievingDate);
	}

	/**
	 * @param relievingDate the relievingDate to set
	 */
	public void setRelievingDate(LocalDate relievingDate) {
		this.relievingDate = relievingDate;
	}

	/**
	 * @return the monthlyFee
	 */
	public Double getMonthlyFee() {
		return monthlyFee;
	}

	/**
	 * @param monthlyFee the monthlyFee to set
	 */
	public void setMonthlyFee(Double monthlyFee) {
		this.monthlyFee = monthlyFee;
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
}
