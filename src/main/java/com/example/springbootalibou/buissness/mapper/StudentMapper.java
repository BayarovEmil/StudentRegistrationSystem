package com.example.springbootalibou.buissness.mapper;

import com.example.springbootalibou.model.School;
import com.example.springbootalibou.model.Student;
import com.example.springbootalibou.model.dtos.StudentRequestDto;
import com.example.springbootalibou.model.dtos.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentRequestDto dto){
        if (dto == null){
            throw new NullPointerException("The student dto is null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school =new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

}
