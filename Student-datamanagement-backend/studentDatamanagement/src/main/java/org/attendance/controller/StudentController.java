package org.attendance.controller;

import java.util.List;

import org.attendance.entity.Student;
import org.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/viewStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}




	// Other endpoints as needed

}
