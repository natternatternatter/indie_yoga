package com.michaelnatter.yogaschedule.controllers;

import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michaelnatter.yogaschedule.models.Course;
import com.michaelnatter.yogaschedule.models.Instructor;
import com.michaelnatter.yogaschedule.services.CourseService;
import com.michaelnatter.yogaschedule.services.InstructorService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorService instructorService;

	@GetMapping("/home")
	public String displayHome(HttpSession session, Model model) {
		if (instructorService.validateSession(session)) {
			
			String firstName= (String)session.getAttribute("firstName");
			model.addAttribute("firstName", firstName);
	    	
			return "home.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/classes")
	public String displayClasses(HttpSession session, Model model, @ModelAttribute("course") Course course) {
		if (instructorService.validateSession(session)) {
			
			String firstName= (String)session.getAttribute("firstName");
			model.addAttribute("firstName", firstName);
			
			List<Course> courses = courseService.allCourses();
	    	model.addAttribute("courses", courses);
	    	
			return "classes.jsp";
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/myClasses")
	public String displayMyClasses(HttpSession session, Model model, @ModelAttribute("course") Course course) {
		if (instructorService.validateSession(session)) {
			
			String firstName= (String)session.getAttribute("firstName");
			model.addAttribute("firstName", firstName);
			
			Long instructorId= (Long)session.getAttribute("instructorId");
			Instructor instructor = instructorService.oneInstructor(instructorId);
			
			List<Course> courses = courseService.getAssignedInstructors(instructor);
	    	model.addAttribute("courses", courses);
	    	
			return "my_schedule.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping ("/classes/new")
	public String displayNewClass(Model model, HttpSession session, @ModelAttribute("course") Course course){
		if (instructorService.validateSession(session)) {
			Long instructorId= (Long)session.getAttribute("instructorId");
			model.addAttribute("instructorId", instructorId);
			return "new_class.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping ("/classes/new/process")
	public String addCourse(HttpSession session, @Valid @ModelAttribute("course") Course course, 
							BindingResult result, RedirectAttributes redirectAttributes) {
		
		if (instructorService.validateSession(session)) {
			if (result.hasErrors()) {
				return "new_class.jsp";
			}
			else {
				Course currentCourse = courseService.createCourse(course);
				Long instructorId= (Long)session.getAttribute("instructorId");
				Long courseId = currentCourse.getId();
				instructorService.connectInstructorToCourse(instructorId, courseId);
				return "redirect:/myClasses";
			}
		}
		return "redirect:/";
	}
	
	@GetMapping ("/classes/{id}/edit")
	public String displayEditClass(HttpSession session, @PathVariable("id")Long id, Model model, @ModelAttribute("course") Course course) {
		if (instructorService.validateSession(session)) {
			Course thisCourse = courseService.oneCourse(id);
			model.addAttribute("course", thisCourse);
			return "edit_class.jsp";
		}
		return "redirect:/";
	}
	
	@PutMapping ("/classes/{id}/edit/process")
	public String editClass(Model model, HttpSession session, @Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (instructorService.validateSession(session)) {
			if (result.hasErrors()) {
				return "edit_class.jsp";
			}
			else {
				Long instructorId= (Long)session.getAttribute("instructorId");
				model.addAttribute("instructorId", instructorId);
				courseService.createCourse(course);
				return "redirect:/classes";
			}
		}
		return "redirect:/";
	}
	
	@DeleteMapping ("/classes/delete/{id}")
	public String deleteCourse(HttpSession session, @PathVariable("id") Long id) {
		if (instructorService.validateSession(session)) {
			courseService.removeCourse(id);
			return "redirect:/classes";
		}
		return "redirect:/";
	}
    
	@RequestMapping ("/classes/{id}")
	public String classDetails(HttpSession session, @PathVariable("id") Long id, Model model) {
		if (instructorService.validateSession(session)) {
			Course course = courseService.oneCourse(id);
			model.addAttribute("course", course);
			
			
			Course thisCourse = courseService.oneCourse(id);
			
			List<Instructor> instructors = instructorService.getAssignedCourses(thisCourse);
	    	model.addAttribute("instructors", instructors);
			
			return "display_class.jsp";
		}
		return "redirect:/";
	}
	
	
}
