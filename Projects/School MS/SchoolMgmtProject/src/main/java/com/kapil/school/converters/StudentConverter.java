package com.kapil.school.converters;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.kapil.school.dto.StudentDTO;
import com.kapil.school.entity.Student;

public class StudentConverter implements Serializable {

	private static ModelMapper modelMapper = new ModelMapper();
	/**
	 *
	 */
	private static final long serialVersionUID = -6680709761303008914L;

	public static Student dtoToEntity(StudentDTO studentDTO) {
		Student student = modelMapper.map(studentDTO, Student.class);
		return student;
	}

	public static StudentDTO entityToDto(Student student) {
		StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
		return studentDTO;
	}

}