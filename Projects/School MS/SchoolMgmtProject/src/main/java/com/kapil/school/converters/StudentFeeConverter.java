package com.kapil.school.converters;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.kapil.school.dto.StudentFeeDTO;
import com.kapil.school.entity.StudentFee;

public class StudentFeeConverter implements Serializable {

	private static ModelMapper modelMapper = new ModelMapper();
	/**
	 *
	 */
	private static final long serialVersionUID = -6680709761303008914L;

	public static StudentFee dtoToEntity(StudentFeeDTO StudentFeeDTO) {
		StudentFee StudentFee = modelMapper.map(StudentFeeDTO, StudentFee.class);
		return StudentFee;
	}

	public static StudentFeeDTO entityToDto(StudentFee StudentFee) {
		StudentFeeDTO StudentFeeDTO = modelMapper.map(StudentFee, StudentFeeDTO.class);
		return StudentFeeDTO;
	}

}