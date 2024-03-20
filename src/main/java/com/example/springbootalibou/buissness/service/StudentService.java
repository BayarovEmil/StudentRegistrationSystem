package com.example.springbootalibou.buissness.service;

import com.example.springbootalibou.buissness.mapper.StudentMapper;
import com.example.springbootalibou.dataAccess.StudentRepository;
import com.example.springbootalibou.model.dtos.StudentRequestDto;
import com.example.springbootalibou.model.dtos.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentRequestDto dto
    ){
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public StudentResponseDto findStudentById(
            Integer id
    ){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentsByName(
            String name
    ){
        return studentRepository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(
            Integer id
    ){
        studentRepository.deleteById(id);
    }

    public List<StudentResponseDto> findAllStudent(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
}
