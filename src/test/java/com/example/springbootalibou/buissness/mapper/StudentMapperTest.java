package com.example.springbootalibou.buissness.mapper;

import com.example.springbootalibou.model.Student;
import com.example.springbootalibou.model.dtos.StudentRequestDto;
import com.example.springbootalibou.model.dtos.StudentResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp(){
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentRequestDto dto = new StudentRequestDto(
                "Emil","Bayarov"
                ,"emil@gmail.com",1
        );

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertEquals(dto.schoolId(),student.getSchool().getId());
        assertNotNull(student.getSchool());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var exp = assertThrows(NullPointerException.class,()->mapper.toStudent(null));
        assertEquals("The student dto should not be null",exp.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        //Given
        Student student = new Student(
          "Elmar","Bayarov","elmar@gmail.com",20
        );
        //When
        StudentResponseDto response = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(response.firstName(),student.getFirstname());
        assertEquals(response.lastName(),student.getLastname());
        assertEquals(response.email(),student.getEmail());
    }
}