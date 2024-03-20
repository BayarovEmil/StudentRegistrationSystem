package com.example.springbootalibou.api;

import com.example.springbootalibou.buissness.service.SchoolService;
import com.example.springbootalibou.model.dtos.SchoolDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

//    @GetMapping("/getAll")
//    public List<School> getAll(){
//        return schoolRepository.findAll();
//    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){
        return schoolService.create(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolService.findAll();
    }
}
