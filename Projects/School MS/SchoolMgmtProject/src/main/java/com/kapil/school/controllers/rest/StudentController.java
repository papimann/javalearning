package com.kapil.school.controllers.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.school.dto.StudentDTO;
import com.kapil.school.repository.StudentRepository;
import com.kapil.school.service.StudentService;

@RequestMapping("/api/student")
@RestController
public class StudentController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8292013569633204826L;

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/all")
	public List<StudentDTO> getAllStudents() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveStudent(@RequestBody StudentDTO studentDTO) {
		studentService.saveStudent(studentDTO);
	}

	@PutMapping("/{id}")
	public void updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Integer id) {
		studentService.updateStudent(studentDTO, id);
	}

}
