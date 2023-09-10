package com.springboot.concepts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.concepts.entity.RateCard;
import com.springboot.concepts.entity.TaxiRide;
import com.springboot.concepts.service.ILinesService;

@RestController
@RequestMapping("/taxi")
public class TaxiController {

    private final ILinesService ilLinesService;

    public TaxiController(ILinesService ILinesService) {
        this.ilLinesService = ILinesService;
    }

    
    @GetMapping("/taxifare/get/")
    public RateCard getTaxiFare() {
        return new RateCard();
    }

    @GetMapping("/taxifare/get/{id}")
    public RateCard getTaxiFareById(@PathVariable long id) {
        return new RateCard();
    }

     @PostMapping("/taxifare/calculate/")
    public String calculateTaxiFare(
      @RequestBody  TaxiRide taxiRide) {
 
        // return the calculated fare
        return "";
    }
}
