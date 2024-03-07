package org.attendance.service;

import org.attendance.entity.Attendance;
import org.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));
        existingAttendance.setDate(attendance.getDate());
        existingAttendance.setTopic(attendance.getTopic());
        existingAttendance.setPresent(attendance.isPresent());
        existingAttendance.setStudent(attendance.getStudent());
        return attendanceRepository.save(existingAttendance);
    }
}
