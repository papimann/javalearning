package com.kapil.school.controllers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.kapil.school.dto.StudentDTO;

@Controller
public class SchoolController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1230544637785976624L;

	private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

	@Value("${spring.application.name}")
	String appName;

	@Value("${spring.student.api}")
	String studentAPI;

	@Value("${spring.application.schoolName}")
	String schoolName;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", appName);
		model.addAttribute("schoolName", schoolName);

		RestTemplate restTemplate = new RestTemplate();
		StudentDTO[] students = restTemplate.getForObject(studentAPI + "/all", StudentDTO[].class);
		List<StudentDTO> studentList = Arrays.stream(students).collect(Collectors.toList());
		model.addAttribute("students", studentList);
		return "index";
	}

	@GetMapping("/students/add")
	public String addStudent(Model model) {
		model.addAttribute("message", appName);
		model.addAttribute("schoolName", schoolName);
		model.addAttribute("student", new StudentDTO());
		return "addStudent";
	}

	@PostMapping("/students/add")
	public ModelAndView saveStudent(@Valid StudentDTO student, BindingResult bindingResult, Model model) {
		ModelAndView view = new ModelAndView("result");
		if (bindingResult.hasErrors()) {
			logger.info("Validation failed : " + bindingResult);
			view = new ModelAndView("redirect:/students/add");
			view.addObject("student", student);
		} else {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<StudentDTO> studentDTO = restTemplate.postForEntity(studentAPI, student, StudentDTO.class);
			view.addObject("student", studentDTO);
		}
		return view;
	}
}
