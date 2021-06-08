package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.CityDto;
import com.nulp.bat.travelagency.dto.CountryDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.City;
import com.nulp.bat.travelagency.model.Country;
import com.nulp.bat.travelagency.repository.CountryRepository;
import com.nulp.bat.travelagency.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public CountryDto getCountry(String name) {
        log.info("getting country from database by name {}", name);
        Country country = countryRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapCountryToCountryDto(country);

    }

    @Override
    public List<CountryDto> getAll() {
        return countryRepository.findAll().stream().map(this::mapCountryToCountryDto).collect(Collectors.toList());

    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        log.info("creating Country in database: {}", countryDto);
        Country country = mapCountryDtoToCountry(countryDto);
        country = countryRepository.save(country);
        return mapCountryToCountryDto(country);
    }

    @Override
    public CountryDto updateCountry(String name, CountryDto countryDto) {
        log.info("updating Country in database: {}", countryDto);
        Country country = mapCountryDtoToCountry(countryDto);
        Country countryFromDB = countryRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        countryRepository.delete(countryFromDB);
        country = countryRepository.save(country);
        return mapCountryToCountryDto(country);
    }

    @Override
    public void deleteCountry(String name) {
        log.info("deleting Country in database by name {}", name);
        Country country = countryRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        countryRepository.delete(country);
    }

    private CountryDto mapCountryToCountryDto(Country country) {
        return CountryDto.builder()
                .name(country.getName())
                .cityList(country.getCityList())
                .build();
    }

    private Country mapCountryDtoToCountry(CountryDto countryDto) {
        return Country.builder()
                .name(countryDto.getName())
                .cityList(countryDto.getCityList())
                .build();
    }
}
