package com.example.springbootalibou.buissness.service;

import com.example.springbootalibou.buissness.mapper.StudentProfileMapper;
import com.example.springbootalibou.dataAccess.StudentProfileRepository;
import com.example.springbootalibou.model.StudentProfile;
import com.example.springbootalibou.model.dtos.StudentProfileRequestDto;
import com.example.springbootalibou.model.dtos.StudentProfileResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {
    private final StudentProfileRepository studentProfileRepository;
    private final StudentProfileMapper studentProfileMapper;
    public StudentProfileService(StudentProfileRepository studentProfileRepository, StudentProfileMapper studentProfileMapper) {
        this.studentProfileRepository = studentProfileRepository;
        this.studentProfileMapper = studentProfileMapper;
    }

    public List<StudentProfile> getAll(){
        return studentProfileRepository.findAll();
    }

    public StudentProfileResponseDto findById(
            Integer id
    ){
        return studentProfileRepository.findById(id)
                .map(studentProfileMapper::toStudentProfileResponseDto)
                .orElse(null);
    }

    public StudentProfileResponseDto add(
            StudentProfileRequestDto dto
    ){
        var studentProfile = studentProfileMapper.toStudentProfile(dto);
        var savedStudentProfile = studentProfileRepository.save(studentProfile);
        return studentProfileMapper.toStudentProfileResponseDto(savedStudentProfile);
    }
}
