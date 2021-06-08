package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.TourDto;

import java.util.List;


public interface TourService {
    TourDto getTour(String name);

    List<TourDto> getAllTour();

    TourDto createTour(TourDto tourDto);

    TourDto updateTour(String name, TourDto tourDto);

    void deleteTour(String name);

    void deleteById(Long idTour);
}
