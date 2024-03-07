package org.attendance.controller;

import org.attendance.dto.AttendanceRequestDto;
import org.attendance.entity.Attendance;
import org.attendance.entity.Student;
import org.attendance.service.AttendanceService;
import org.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private StudentService studentService;

	@PostMapping("/addAttendance")
	public ResponseEntity<?> addAttendance(@RequestBody AttendanceRequestDto attendanceRequestDto) {
		Student student = null;
		if (attendanceRequestDto.getStudent().getId() != null) {
			// If the student ID is provided, check if the student exists
			student = studentService.getStudentById(attendanceRequestDto.getStudent().getId());
		}

		// If student is still null, it means the student doesn't exist, create a new
		// student
		if (student == null) {
			student = new Student();
			student.setName(attendanceRequestDto.getStudent().getName());
			student.setBatch(attendanceRequestDto.getStudent().getBatch());
			student = studentService.addStudent(student);
		}

		// Create new attendance object
		Attendance attendance = new Attendance();
		attendance.setDate(attendanceRequestDto.getDate());
		attendance.setTopic(attendanceRequestDto.getTopic());
		attendance.setPresent(attendanceRequestDto.isPresent());
		attendance.setStudent(student);

		// Save the attendance
		Attendance savedAttendance = attendanceService.markAttendance(attendance);

		return ResponseEntity.ok(savedAttendance);
	}
}
