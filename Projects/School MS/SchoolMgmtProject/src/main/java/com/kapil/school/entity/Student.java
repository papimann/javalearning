/**
 *
 */
package com.kapil.school.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 261009031561268523L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile", length = 10)
	private int mobile;

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

	@Column(name = "monthlyFee")
	private Double monthlyFee;

	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	@Column
	@OneToMany(mappedBy = "student")
	@Nullable
	private List<StudentFee> fees;

}