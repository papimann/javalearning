/**
 *
 */
package com.kapil.school.service;

import java.util.List;

import com.kapil.school.dto.StudentDTO;

/**
 * @author kapil.arora
 *
 */
public interface StudentService {
	StudentDTO getStudentById(Integer studentId);

	void saveStudent(StudentDTO studentDTO);

	List<StudentDTO> getAllStudents();

	StudentDTO updateStudent(StudentDTO studentDTO, Integer id);
}
