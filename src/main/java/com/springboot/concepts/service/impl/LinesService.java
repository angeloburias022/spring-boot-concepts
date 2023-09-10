package com.springboot.concepts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.concepts.dto.LineDTO;
import com.springboot.concepts.dto.StationDTO;
import com.springboot.concepts.entity.Line;
import com.springboot.concepts.entity.Station;
import com.springboot.concepts.repository.LinesRepository;
import com.springboot.concepts.repository.StationRepository;
import com.springboot.concepts.service.ILinesService;

@Service
public class LinesService implements ILinesService {

    private final LinesRepository linesRepository;
    private final StationRepository stationRepository;
    // private final

    @Autowired
    public LinesService(LinesRepository linesRepository, StationRepository stationRepository) {
        this.linesRepository = linesRepository;
        this.stationRepository = stationRepository;
    }

    @Override
    public Line saveLine(LineDTO lineDTO) {

        List<Station> stations = new ArrayList<>();
        
        Line line = new Line();

        Station station = new Station();
        
        line.setLineName(lineDTO.getLineName());
        line.setStatus(lineDTO.getStatus());
        
        var newLine = linesRepository.save(line);

        lineDTO.getStations().stream().forEach(stat -> {
            station.setIsLastStation(stat.getIsLastStation());
            station.setStationName(stat.getStationName());
            station.setStatus(stat.getStatus());
            station.setLine(newLine);
            station.setStationAlias(stat.getStationAlias());
            
            stations.add(station);
            }
        );

        stationRepository.saveAll(stations);


        return newLine;
    }

    @Override
    public Page<LineDTO> getAllLines(Pageable pageable) {
        return linesRepository.findAll(pageable).map(this::buildLineDTOs);
    }

    private LineDTO buildLineDTOs(Line line) {
        LineDTO lineDTO = new LineDTO();
        lineDTO.setId(line.getId());
        lineDTO.setLineName(line.getLineName());
        lineDTO.setStatus(line.getStatus());
        lineDTO.setDateCreated(line.getDateCreated());
        lineDTO.setDateModified(line.getDateModified());
        return lineDTO;
    }
    
}
