package org.attendance.service;

import java.util.List;

import org.attendance.entity.Student;
import org.attendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(null);
	}

	// Other methods as needed
}
