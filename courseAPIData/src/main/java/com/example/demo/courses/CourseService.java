package com.example.demo.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(String id) {
		// return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCourse(String id) {
		// return topics.stream().filter(topic ->
		// topic.getId().equalsIgnoreCase(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		// getTopics().add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		System.out.println("Hi");
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		// topics.removeIf(t -> t.getId().equals(id));
	}

}
