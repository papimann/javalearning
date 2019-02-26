/**
 *
 */
package com.kapil.microservices.socialmultiplications.datalayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.kapil.microservices.socialmultiplications.businesslayer.domain.Multiplication;

/**
 * This interface allows us to save and retrieve Users
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
