package com.springboot.concepts.service;

import org.springframework.stereotype.Service;

import com.springboot.concepts.entity.TaxiRide;

@Service
public class TaxiFareCalculatorService {
    
    public String calculateFare(TaxiRide taxiRide) {
        return String.valueOf((Long) (taxiRide.getIsNightSurcharge()
          ? taxiRide.getDistanceInMile() * 10 + 100
          : taxiRide.getDistanceInMile() * 10));
    }
}
