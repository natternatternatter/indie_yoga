package com.michaelnatter.yogaschedule.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	List<Course> findAll();
	
	Optional<Course> findById(Long id);
	
	@SuppressWarnings("unchecked")
	Course save(Course course);
	
	void deleteById(Long id);
	
	List<Course> findAllByInstructors(Instructor instructor);
}
