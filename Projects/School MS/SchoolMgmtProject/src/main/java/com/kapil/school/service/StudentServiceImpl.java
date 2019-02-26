package com.kapil.school.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.school.converters.StudentConverter;
import com.kapil.school.dto.StudentDTO;
import com.kapil.school.entity.Student;
import com.kapil.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8349163594217197385L;
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentDTO getStudentById(Integer studentId) {
		Student student = studentRepository.findById(studentId).get();// .orElseThrow(StudentNotFoundException::new);
		return StudentConverter.entityToDto(student);
	}

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		studentRepository.save(StudentConverter.dtoToEntity(studentDTO));
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		return studentRepository.findAll().stream().map(StudentConverter::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO, Integer id) {
		Student student = StudentConverter.dtoToEntity(studentDTO);
		/*
		 * if (student.getId() != id) { throw new
		 * Exception("Student Id does not match"); }
		 */
//		studentRepository.findById(id).orElseThrow(new RuntimeException("Student Not Found"));
		return StudentConverter.entityToDto(studentRepository.save(student));
	}

}
