package com.example.springbootalibou.dataAccess;

import com.example.springbootalibou.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstnameContaining(String word);
}
