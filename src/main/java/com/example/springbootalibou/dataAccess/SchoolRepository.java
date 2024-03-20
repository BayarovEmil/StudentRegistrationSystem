package com.example.springbootalibou.dataAccess;

import com.example.springbootalibou.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
