package com.springboot.concepts.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.concepts.dto.LineDTO;
import com.springboot.concepts.entity.Line;

public interface ILinesService {
    public Line saveLine(LineDTO LineDTO);

    public Page<LineDTO> getAllLines(Pageable pageable);

}
