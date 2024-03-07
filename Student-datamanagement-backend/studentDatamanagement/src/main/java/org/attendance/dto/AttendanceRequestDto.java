package org.attendance.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequestDto {
    private LocalDate date;
    private String topic;
    private boolean present;
    private StudentDto student;
}
