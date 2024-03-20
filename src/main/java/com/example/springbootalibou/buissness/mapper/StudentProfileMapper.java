package com.example.springbootalibou.buissness.mapper;

import com.example.springbootalibou.model.Student;
import com.example.springbootalibou.model.StudentProfile;
import com.example.springbootalibou.model.dtos.StudentProfileRequestDto;
import com.example.springbootalibou.model.dtos.StudentProfileResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileMapper {
    public StudentProfileResponseDto toStudentProfileResponseDto(StudentProfile studentProfile) {
        return new StudentProfileResponseDto(
                studentProfile.getBio()
        );
    }

    public StudentProfile toStudentProfile(StudentProfileRequestDto dto) {
        var studentProfile = new StudentProfile();
        studentProfile.setBio(dto.bio());

        var student = new Student();
        student.setId(dto.studentId());

        studentProfile.setStudent(student);

        return studentProfile;
    }
}
