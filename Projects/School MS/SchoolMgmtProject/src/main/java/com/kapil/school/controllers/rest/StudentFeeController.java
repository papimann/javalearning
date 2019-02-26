package com.kapil.school.controllers.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.school.dto.StudentFeeDTO;
import com.kapil.school.service.StudentFeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/studentFee")
@RestController
public class StudentFeeController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7107452263652395892L;

	@Autowired
	StudentFeeService studentFeeService;

	@GetMapping(path = { "/{id}" })
	public StudentFeeDTO getStudentFeeById(@PathVariable("id") Integer id) {
		return studentFeeService.getStudentFeeById(id);
	}

	@GetMapping
	public List<StudentFeeDTO> getAllStudentFees() {
		return studentFeeService.getAllStudentFees();
	}

	@PostMapping
	public void saveStudentFee(@RequestBody StudentFeeDTO studentFeeDTO) {
		studentFeeService.saveStudentFee(studentFeeDTO);
	}
}
