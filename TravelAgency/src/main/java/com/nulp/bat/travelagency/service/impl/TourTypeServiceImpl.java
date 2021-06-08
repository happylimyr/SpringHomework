package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.TourTypeDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.TourType;
import com.nulp.bat.travelagency.repository.TourTypeRepository;
import com.nulp.bat.travelagency.service.TourTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourTypeServiceImpl implements TourTypeService {

    private final TourTypeRepository tourTypeRepository;

    @Override
    public TourTypeDto getTourType(String name) {
        TourType statuses = tourTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapTourTypeToTourTypeDto(statuses);
    }

    @Override
    public TourTypeDto createTourType(TourTypeDto tourTypeDto) {
        TourType status = mapTourTypeDtoToTourType(tourTypeDto);
        status = tourTypeRepository.save(status);
        return mapTourTypeToTourTypeDto(status);
    }

    @Override
    public List<TourTypeDto> getAll() {
        return tourTypeRepository.findAll().stream().map(this::mapTourTypeToTourTypeDto).collect(Collectors.toList());
    }

    @Override
    public TourTypeDto updateTourType(String name, TourTypeDto tourTypeDto) {
        TourType statuses = mapTourTypeDtoToTourType(tourTypeDto);
        TourType statusFromDB = tourTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        tourTypeRepository.delete(statusFromDB);
        statuses = tourTypeRepository.save(statuses);
        return mapTourTypeToTourTypeDto(statuses);
    }

    @Override
    public void deleteTourType(String name) {
        TourType statuses = tourTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        tourTypeRepository.delete(statuses);
    }

    private TourTypeDto mapTourTypeToTourTypeDto(TourType statuses) {
        return TourTypeDto.builder()
                .name(statuses.getName())
                .build();
    }

    private TourType mapTourTypeDtoToTourType(TourTypeDto tourTypeDto) {
        return TourType.builder()
                .name(tourTypeDto.getName())
                .build();
    }
}
