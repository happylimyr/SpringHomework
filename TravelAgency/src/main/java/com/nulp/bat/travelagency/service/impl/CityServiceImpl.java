package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.CityDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.City;
import com.nulp.bat.travelagency.model.Country;
import com.nulp.bat.travelagency.repository.CityRepository;
import com.nulp.bat.travelagency.repository.CountryRepository;
import com.nulp.bat.travelagency.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public CityDto getCity(String name) {
        log.info("getting city from database by name {}", name);
        City city = cityRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapCityToCityDto(city);
    }

    @Override
    public List<CityDto> getAll() {
        return cityRepository.findAll().stream().map(this::mapCityToCityDto).collect(Collectors.toList());

    }

    @Override
    public CityDto createCity(CityDto cityDto) {
        log.info("creating City in database: {}", cityDto);
        City city = mapCityDtoToCity(cityDto);
        city = cityRepository.save(city);
        return mapCityToCityDto(city);
    }

    @Override
    public CityDto updateCity(String name, CityDto cityDto) {
        log.info("updating City in database: {}", cityDto);
        City cityFromDB = cityRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
//        if (cityDto.getCountry().isEmpty()) {
//            cityDto.setCountry(cityFromDB.getCountry().getName());
//        }
        City city = mapCityDtoToCity(cityDto);
        cityRepository.delete(cityFromDB);
        city = cityRepository.save(city);
        return mapCityToCityDto(city);
    }

    @Override
    public void deleteCity(String name) {
        log.info("deleting city in database by name {}", name);
        City city = cityRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        cityRepository.delete(city);

    }

    private CityDto mapCityToCityDto(City city) {
        return CityDto.builder()
                .name(city.getName())
                .addressList(city.getAddressList())
                .build();
    }

    private City mapCityDtoToCity(CityDto cityDto) {
        return City.builder()
                .name(cityDto.getName())
//                .country(countryRepository.findByName(cityDto.getCountry()).orElse(new Country().builder()
//                        .name(cityDto.getCountry())
//                        .build()))
                .country(cityDto.getCountry())
                .addressList(cityDto.getAddressList())
                .build();
    }
}
