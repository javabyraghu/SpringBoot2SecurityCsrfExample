package in.nit.raghu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.nit.raghu.model.Student;
import in.nit.raghu.repo.StudentRepository;

@Controller
public class StudentController {
	
	private static Logger log=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository repo;
	
	@GetMapping("/")
	public String showReg(Model model) {
		log.info("Entered into show method");
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Student student,Model model) {
		log.info("Entered into save method");
		Integer id=repo.save(student).getStdId();
		model.addAttribute("message", "Student Saved!"+id);
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}
}
