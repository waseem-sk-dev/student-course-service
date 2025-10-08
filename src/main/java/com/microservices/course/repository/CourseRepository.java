package com.microservices.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
