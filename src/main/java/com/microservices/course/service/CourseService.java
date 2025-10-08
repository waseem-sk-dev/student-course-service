package com.microservices.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.course.entity.Course;
import com.microservices.course.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {
	private final CourseRepository courseRepository;

	@Transactional(readOnly = true)
	public Course getCourseById(Long id) {
		log.info("Fetching course with id: {}", id);
		return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

	}

	@Transactional(readOnly = true)
	public List<Course> getCourseByIds(List<Long> ids) {
		log.info("Fetching courses with ids: {}", ids);
		return courseRepository.findAllById(ids);
	}

	@Transactional(readOnly = true)
	public List<Course> getAllCourses() {
		log.info("Fetching all courses");
		return courseRepository.findAll();
	}

	@Transactional
	public Course createCourse(Course course) {
		log.info("Creating new course: {}", course.getCourseName());
		return courseRepository.save(course);
	}

}
