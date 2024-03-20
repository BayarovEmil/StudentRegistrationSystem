package com.example.springbootalibou.api;

import com.example.springbootalibou.buissness.service.StudentProfileService;
import com.example.springbootalibou.model.StudentProfile;
import com.example.springbootalibou.model.dtos.StudentProfileRequestDto;
import com.example.springbootalibou.model.dtos.StudentProfileResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentProfileController {
    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @GetMapping("/getAll")
    public List<StudentProfile> getAll(){
        return studentProfileService.getAll();
    }

    @GetMapping("/findById/search/{id}")
    public StudentProfileResponseDto findById(
            @PathVariable("id") Integer id
    ){
        return studentProfileService.findById(id);
    }

    @PostMapping("/add")
    public StudentProfileResponseDto add(
            @RequestBody StudentProfileRequestDto dto
    ){
        return studentProfileService.add(dto);
    }


}
