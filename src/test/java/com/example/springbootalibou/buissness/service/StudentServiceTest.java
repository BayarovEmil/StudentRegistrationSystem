package com.example.springbootalibou.buissness.service;

import com.example.springbootalibou.buissness.mapper.StudentMapper;
import com.example.springbootalibou.dataAccess.StudentRepository;
import com.example.springbootalibou.model.Student;
import com.example.springbootalibou.model.dtos.StudentRequestDto;
import com.example.springbootalibou.model.dtos.StudentResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    //which service we want to test
    @InjectMocks
    private StudentService studentService;
    // declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student(){
        // Given
        StudentRequestDto dto = new StudentRequestDto(
                "Emil","Bayarov","emil@gmail.com",20
        );
        Student student = new Student(
                "Elmar","Bayarov","elmar@gmail.com",20
        );
        Student savedStudent = new Student(
                "Elxan","Isayev","elxan@gmail.com",20
        );
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "","",""));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstname(),responseDto.firstName());
        assertEquals(dto.lastname(),responseDto.lastName());
        assertEquals(dto.email(),responseDto.email());

        verify(studentMapper,times(1))
                .toStudent(dto);
        verify(studentRepository,times(1))
                .save(student);
        verify(studentMapper,times(1))
                .toStudentResponseDto(savedStudent);

    }

    @Test
    public void should_return_all_students(){
        //Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Elmar","Bayarov","elmar@gmail.com",20
        ));

        // Mock the calls
        when(studentRepository.findAll())
                .thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Elmar","Bayarov","elmar@gmail.com"
                ));

        //When
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(),responseDtos.size());
        verify(studentRepository,times(1)).findAll();

    }

    @Test
    public void should_return_student_by_id(){
        //Given
        Integer studentId = 1;
        Student student = new Student(
                "Elmar","Bayarov","elmar@gmail.com",20
        );

        //Mock the calls
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Elmar","Bayarov","elmar@gmail.com"
                ));

        //When
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //Then
        assertEquals(dto.firstName(),student.getFirstname());
        assertEquals(dto.lastName(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());

        verify(studentRepository,times(1)).findById(studentId);
    }
}