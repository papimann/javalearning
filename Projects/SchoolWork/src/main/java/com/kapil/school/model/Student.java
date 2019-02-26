package com.kapil.school.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Entity
//@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId", updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "fatherName")
	private String fatherName;

	@Column(name = "motherName")
	private String motherName;

	@Column(name = "aadhaarNumber", length = 12)
	private int aadhaarNumber;

	@Column(name = "panCard")
	private String panCard;

	@Column(name = "admissionDate")
	private LocalDate admissionDate;

	@Column(name = "relieveDate")
	private LocalDate relievingDate;

	@Column(name = "feesReceived")
	private List<Fee> receivedFees;

	@Column(name = "monthlyFee")
	private Double monthlyFee;

	@Column(name = "pendingFees")
	private Map<String, Double> pendingFees;

	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	/**
	 * Default Constructors
	 */
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}

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
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
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
	 * @return the receivedFees
	 */
	public List<Fee> getReceivedFees() {
		return receivedFees;
	}

	/**
	 * @param receivedFees the receivedFees to set
	 */
	public void setReceivedFees(List<Fee> receivedFees) {
		this.receivedFees = receivedFees;
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
	 * @return the pendingFees
	 */
	public Map<String, Double> getPendingFees() {
		return pendingFees;
	}

	/**
	 * @param pendingFees the pendingFees to set
	 */
	public void setPendingFees(Map<String, Double> pendingFees) {
		this.pendingFees = pendingFees;
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
