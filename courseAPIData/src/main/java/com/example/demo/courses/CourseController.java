package com.example.demo.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topics.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		System.out.println("Hello");
		course.setTopic(new Topic(topicId));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
