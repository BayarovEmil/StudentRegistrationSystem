package com.example.springbootalibou.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    private School school;


    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
}
