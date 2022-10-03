package com.michaelnatter.yogaschedule.controllers;




import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michaelnatter.yogaschedule.models.LoginInstructor;

import com.michaelnatter.yogaschedule.models.Instructor;
import com.michaelnatter.yogaschedule.services.InstructorService;


@Controller
public class InstructorController {
	    
	@Autowired
	private InstructorService instructorService;
	    
	@GetMapping("/")
	public String displayLogin(@ModelAttribute("newInstructor")Instructor newInstructor,
												@ModelAttribute("loginInstructor")LoginInstructor loginInstructor) {
	    return "login.jsp";
	}
	
	@GetMapping("/registration")
	public String displayRegistration(@ModelAttribute("newInstructor")Instructor newInstructor,
												@ModelAttribute("loginInstructor")LoginInstructor loginInstructor) {
	    return "registration.jsp";
	}
	    
	@PostMapping("/process/registration")
	public String register(@Valid @ModelAttribute("newInstructor") Instructor newInstructor, 
	        				BindingResult result, Model model, HttpSession session,
								@ModelAttribute("loginInstructor")LoginInstructor loginInstructor) {
	        
		Instructor createdInstructor = instructorService.register(newInstructor, result);
		
	    if(result.hasErrors()) {
	        return "registration.jsp";
	    }
	    
	    session.setAttribute("firstName", createdInstructor.getFirstName());
	    session.setAttribute("lastName", createdInstructor.getLastName());
	    session.setAttribute("instructorId", createdInstructor.getId());
	    	    
	    return "redirect:/home";
	}
	    
	@PostMapping("/process/login")
	public String login(@Valid @ModelAttribute("loginInstructor") LoginInstructor loginInstructor, 
	        			BindingResult result, Model model, HttpSession session,
	        			@ModelAttribute("newInstructor")Instructor newInstructor) {
	        
	Instructor currentInstructor = instructorService.loginInstructor(loginInstructor, result);
	    
	    if(result.hasErrors()) {
	        return "login.jsp";
	    }
	    
	    session.setAttribute("firstName", currentInstructor.getFirstName());
	    session.setAttribute("lastName", currentInstructor.getLastName());
	    session.setAttribute("instructorId", currentInstructor.getId());
	    
	    return "redirect:/home";
	}
	
	@PostMapping("classes/join")
	public String joinClass(Model model, HttpSession session, @RequestParam(value="courseId") Long courseId, RedirectAttributes redirectAttributes) {
		if (instructorService.validateSession(session)) {
			Long instructorId= (Long)session.getAttribute("instructorId");
			Instructor check = instructorService.connectInstructorToCourse(instructorId, courseId);
			if(check == null) {
				model.addAttribute("courseId", courseId);
				redirectAttributes.addFlashAttribute("error", "You are already signed up for this class! You cannot sign up for it again!");
				return "redirect:/classes/"+courseId;
			}
			return "redirect:/classes/make_payment";
		}
		return "redirect:/";
	}
	    	
	
	@GetMapping("/process/logout")
	public String processLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}