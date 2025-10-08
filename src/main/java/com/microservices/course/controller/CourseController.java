package com.microservices.course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.course.entity.Course;
import com.microservices.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id) {
		return ResponseEntity.ok(courseService.getCourseById(id));
	}

	@GetMapping("/batch")
	public ResponseEntity<List<Course>> getCourseByIds(@RequestParam List<Long> ids) {
		return ResponseEntity.ok(courseService.getCourseByIds(ids));
	}

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		return ResponseEntity.ok(courseService.getAllCourses());
	}

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.createCourse(course));
	}
}
