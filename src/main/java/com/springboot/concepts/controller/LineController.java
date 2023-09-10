package com.springboot.concepts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.concepts.dto.LineDTO;
import com.springboot.concepts.entity.Line;
import com.springboot.concepts.service.ILinesService;
import com.springboot.concepts.utils.PageUtils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Controller("/lines")
public class LineController {
    
   
    private final ILinesService iLinesService;

    @Autowired
    public LineController(ILinesService iLinesService) {
        this.iLinesService = iLinesService;
    }

    @PostMapping("/save")
    public ResponseEntity addLine(@RequestBody LineDTO lineDTO) {
        return new ResponseEntity(iLinesService.saveLine(lineDTO), HttpStatus.OK);
    }
    
    @GetMapping()
    public ResponseEntity getLines(
        @RequestParam int pageSize,
        @RequestParam int pageNumber
    ) {
        return new ResponseEntity<>(iLinesService.getAllLines(
            PageRequest.of(--pageNumber, pageSize)), HttpStatus.OK);
    }


}
