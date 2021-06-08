package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.CountryApi;
import com.nulp.bat.travelagency.controller.assembler.CountryAssembler;
import com.nulp.bat.travelagency.controller.model.CityModel;
import com.nulp.bat.travelagency.controller.model.CountryModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.CityDto;
import com.nulp.bat.travelagency.dto.CountryDto;
import com.nulp.bat.travelagency.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController implements CountryApi {

    private final CountryService countryService;
    private final CountryAssembler countryAssembler;

    @Override
    public CountryModel getCountry(String name) {
        log.info("getCountry: name {}", name);
        CountryDto country = countryService.getCountry(name);
        return countryAssembler.toModel(country);
    }

    @Override
    public List<CountryModel> getAll() {
        List<CountryDto> addressDtoList = countryService.getAll();
        return countryAssembler.modelList(addressDtoList);
    }

    @Override
    public CountryModel createCountry(CountryDto countryDto) {
        log.info("createCountry: name {}", countryDto.getName());
        CountryDto country = countryService.createCountry(countryDto);
        return countryAssembler.toModel(country);
    }

    @Override
    public CountryModel updateCountry(String name, CountryDto countryDto) {
        log.info("updateCountry: name {}", name);
        CountryDto country = countryService.updateCountry(name, countryDto);
        return countryAssembler.toModel(country);
    }

    @Override
    public ResponseEntity<Void> deleteCountry(String name) {
        log.info("deleteCountry: name {}", name);
        countryService.deleteCountry(name);
        return ResponseEntity.noContent().build();
    }

}
