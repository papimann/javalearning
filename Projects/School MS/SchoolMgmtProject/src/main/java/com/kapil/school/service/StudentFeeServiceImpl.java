package com.kapil.school.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.school.converters.StudentFeeConverter;
import com.kapil.school.dto.StudentFeeDTO;
import com.kapil.school.repository.StudentFeeRepository;

@Service
public class StudentFeeServiceImpl implements StudentFeeService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8349163594217197385L;

	@Autowired
	StudentFeeRepository studentFeeRepository;

	@Override
	public StudentFeeDTO getStudentFeeById(Integer studentId) {
		return StudentFeeConverter.entityToDto(studentFeeRepository.getOne(studentId));
	}

	@Override
	public void saveStudentFee(StudentFeeDTO StudentFeeDTO) {
		studentFeeRepository.save(StudentFeeConverter.dtoToEntity(StudentFeeDTO));
	}

	@Override
	public List<StudentFeeDTO> getAllStudentFees() {
		return studentFeeRepository.findAll().stream().map(StudentFeeConverter::entityToDto)
				.collect(Collectors.toList());
	}

}
