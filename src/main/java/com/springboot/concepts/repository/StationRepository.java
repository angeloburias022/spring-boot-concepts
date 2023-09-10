package com.springboot.concepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.concepts.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    
}
