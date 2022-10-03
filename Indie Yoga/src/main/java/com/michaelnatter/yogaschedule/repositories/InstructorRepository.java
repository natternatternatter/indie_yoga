package com.michaelnatter.yogaschedule.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    
    Optional<Instructor> findByEmail(String email);
    
    Optional<Instructor> findById(Long id);
    
    @SuppressWarnings("unchecked")
	Instructor save(Instructor instructor);
    
    List<Instructor> findAllByCourses(Course course);
    
//    @Query("SELECT c FROM Course c.instructors i WHERE i.id = ?1")
//    Course getAllCoursesUnderInstructorId(Long id);
    
}