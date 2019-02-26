/**
 *
 */
package com.shkp.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shkp.school.beans.Student;

/**
 * @author kapil.arora
 *
 */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
