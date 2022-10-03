package com.michaelnatter.yogaschedule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;
import com.michaelnatter.yogaschedule.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
//	@Autowired
//	private InstructorService instructorService;
	
	
	public List<Course> allCourses() {
        return courseRepository.findAll();
    }
	
	public List<Course> getAssignedInstructors(Instructor instructor){
		return courseRepository.findAllByInstructors(instructor);
	}
    
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public Course oneCourse(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		}else {
			return null;
		}
    }
    
    public void removeCourse(Long id) {
    	courseRepository.deleteById(id);
    }
    
//    public Course connectCourseToInstructor(Long courseId, Long instructorId) {
//    // retrieve an instance of a category using another method in the service.
//    	Course thisCourse = oneCourse(courseId);
//    
//    // retrieve an instance of a product using another method in the service.
//    	Instructor thisInstructor = instructorService.oneInstructor(instructorId);
//    
//    // add the product to this category's list of products
//    	thisCourse.getInstructors().add(thisInstructor);
//    
//    // Save thisCategory, since you made changes to its product list.
//    	return courseRepository.save(thisCourse);
//    }
}
