package in.sudha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.sudha.entity.Student;
import in.sudha.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		init(model);
		return "index";
	}


	private void init(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", service.getCourses());
		model.addAttribute("prefTimings", service.getTimings());
	}
	
	
	@PostMapping("/save")
	public String handleSubmit(Student s,Model model) {
		model.addAttribute("msg","Data Saved!!!");
		init(model);

		return "index";
		
		
	}

}
