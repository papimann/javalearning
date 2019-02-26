/**
 *
 */
package com.kapil.microservices.socialmultiplications.datalayer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.User;

/**
 * This interface allows us to save and retrieve Users
 */
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByAlias(final String alias);
}
