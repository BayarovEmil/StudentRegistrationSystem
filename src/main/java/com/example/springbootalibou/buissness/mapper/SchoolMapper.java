package com.example.springbootalibou.buissness.mapper;

import com.example.springbootalibou.model.School;
import com.example.springbootalibou.model.dtos.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }
    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
