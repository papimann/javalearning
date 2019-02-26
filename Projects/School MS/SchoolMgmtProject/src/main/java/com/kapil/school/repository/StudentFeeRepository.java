/**
 *
 */
package com.kapil.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.school.entity.StudentFee;

/**
 * @author kapil.arora
 *
 */
@Repository
public interface StudentFeeRepository extends JpaRepository<StudentFee, Integer> {

}
