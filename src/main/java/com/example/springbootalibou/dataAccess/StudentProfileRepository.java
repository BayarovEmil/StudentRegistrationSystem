package com.example.springbootalibou.dataAccess;

import com.example.springbootalibou.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile,Integer> {
}
