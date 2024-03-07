package org.attendance.repository;

import java.util.List;

import org.attendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}