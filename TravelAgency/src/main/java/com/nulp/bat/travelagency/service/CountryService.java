package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.CountryDto;

import java.util.List;

public interface CountryService {
    CountryDto getCountry(String name);

    List<CountryDto> getAll();

    CountryDto createCountry(CountryDto countryDto);

    CountryDto updateCountry(String name, CountryDto countryDto);

    void deleteCountry(String name);
}
