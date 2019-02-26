/**
 *
 */
package com.kapil.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.school.entity.Student;

/**
 * @author kapil.arora
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
