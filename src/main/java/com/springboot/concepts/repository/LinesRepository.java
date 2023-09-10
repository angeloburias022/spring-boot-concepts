package com.springboot.concepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.concepts.entity.Line;

@Repository
public interface LinesRepository extends JpaRepository<Line, Long> {
    
}
