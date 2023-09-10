package com.springboot.concepts.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineDTO {
    private Long id;
    private String lineName;
    private List<StationDTO> stations = new ArrayList<>();
    private int status;
    private Date dateCreated;
    private Date dateModified; 
}
