package com.example.springbootalibou.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public School(String name) {
        this.name = name;
    }

//    @onetomany( mappedby = "school"
//    )
//    @JsonManagedReference
//    private List<Student> students;
}
