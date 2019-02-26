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
 * Stores information to identify the user.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8890341043546460071L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	private final String alias;

	// Empty constructor for JSON (de)serialization
	protected User() {
		alias = null;
	}
}
