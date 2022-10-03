package com.michaelnatter.yogaschedule.services;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.michaelnatter.yogaschedule.models.LoginInstructor;
import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;
import com.michaelnatter.yogaschedule.repositories.InstructorRepository;
    
@Service
public class InstructorService {
    
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CourseService courseService;
    

    public Instructor register(Instructor newInstructor, BindingResult result) {
    	
    	Optional<Instructor> checkInstructor=instructorRepository.findByEmail(newInstructor.getEmail());
    	
    	if (checkInstructor.isPresent()) {
    		result.rejectValue("email", "Matches", "This email has already been registered, try another");
    		return null;
    	}
    		
    	if(!newInstructor.getPassword().equals(newInstructor.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Your password and confirm password do not match");
        	return null;
        }
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	String hashPassword = BCrypt.hashpw(newInstructor.getPassword(), BCrypt.gensalt());
    	newInstructor.setPassword(hashPassword);
    	
    	return instructorRepository.save(newInstructor);
    }

    	
    public Instructor loginInstructor(LoginInstructor loginInstructor, BindingResult result) {
    	Optional<Instructor> checkInstructor=instructorRepository.findByEmail(loginInstructor.getEmail());
    	
    	if (! checkInstructor.isPresent()) {
    		result.rejectValue("email", "Matches", "This email is not registered");
    		return null;
    	}
    	
    	Instructor currentInstructor=checkInstructor.get();
    	
    	if(! BCrypt.checkpw(loginInstructor.getPassword(), currentInstructor.getPassword())) {
    		result.rejectValue("password", "Matches", "That password does not match that email");
    		return null;
    	}
    	
    	return currentInstructor;
    	
    }
  
    public Boolean validateSession(HttpSession session) {
    	if (session.getAttribute("instructorId")==null) {
    		session.invalidate();
    		return false;
    	}
    	return true;
    }
    
    public Instructor oneInstructor(Long id) {
		Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
		if(optionalInstructor.isPresent()) {
			return optionalInstructor.get();
		}else {
			return null;
		}
    }
    
	public List<Instructor> getAssignedCourses(Course course){
		return instructorRepository.findAllByCourses(course);
	}
    
    public Instructor connectInstructorToCourse(Long instructorId, Long courseId) {
    
    // retrieve an instance of a category using another method in the service.
    
    	Instructor thisInstructor = oneInstructor(instructorId);

    // retrieve an instance of a product using another method in the service.
    
    	Course thisCourse = courseService.oneCourse(courseId);
    
    
    // add the product to this category's list of products
    	if(thisInstructor.getCourses().contains(thisCourse)) {
    		return null;
    	} else {
    	thisInstructor.getCourses().add(thisCourse);
    	}
    // Save thisCategory, since you made changes to its product list.
    	return instructorRepository.save(thisInstructor);
    }
    
}