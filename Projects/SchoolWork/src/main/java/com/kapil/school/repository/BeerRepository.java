package com.kapil.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kapil.school.model.Beer;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long>{

}
