/**
 *
 */
package com.kapil.microservices.socialmultiplications.businesslayer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This represents a Multiplication (a * b).
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Multiplication implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6782520719619562003L;

	@Id
	@GeneratedValue
	@Column(name = "MULTIPLICATION_ID")
	private Long id;

	// Both factors
	private final int factorA;
	private final int factorB;

	// Empty constructor for JSON (de)serialization
	Multiplication() {
		this(0, 0);
	}
}
