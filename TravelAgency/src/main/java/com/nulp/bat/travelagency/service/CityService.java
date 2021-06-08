package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.CityDto;

import java.util.List;

public interface CityService {
    CityDto getCity(String name);

    List<CityDto> getAll();

    CityDto createCity(CityDto cityDto);

    CityDto updateCity(String name, CityDto cityDto);

    void deleteCity(String name);
}
