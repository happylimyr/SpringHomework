package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.TourTypeDto;

import java.util.List;

public interface TourTypeService {
    TourTypeDto getTourType(String name);

    TourTypeDto createTourType(TourTypeDto tourTypeDto);

    List<TourTypeDto> getAll();

    TourTypeDto updateTourType(String name, TourTypeDto tourTypeDto);

    void deleteTourType(String name);
}
