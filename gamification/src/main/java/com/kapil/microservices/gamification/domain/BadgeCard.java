package com.kapil.microservices.gamification.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.kapil.microservices.gamification.enums.Badge;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This class links a Badge to a User. Contains also a timestamp with the moment
 * in which the user got it.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class BadgeCard implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4596323632176375063L;

	@Id
	@GeneratedValue
	@Column(name = "BADGE_ID")
	private final Long badgeId;

	private final Long userId;

	private final long badgeTimestamp;

	private final Badge badge;

	// Empty constructor for JSON / JPA
	public BadgeCard() {
		this(null, null, 0, null);
	}

	public BadgeCard(final Long userId, final Badge badge) {
		this(null, userId, System.currentTimeMillis(), badge);
	}

}
