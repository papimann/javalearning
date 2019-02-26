/**
 *
 */
package com.kapil.school.service;

import java.util.List;

import com.kapil.school.dto.StudentFeeDTO;

/**
 * @author kapil.arora
 *
 */
public interface StudentFeeService {
	StudentFeeDTO getStudentFeeById(Integer studentFeeId);

	void saveStudentFee(StudentFeeDTO studentFeeDTO);

	List<StudentFeeDTO> getAllStudentFees();
}
