package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.CityApi;
import com.nulp.bat.travelagency.controller.assembler.CityAssembler;
import com.nulp.bat.travelagency.controller.model.CityModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.CityDto;
import com.nulp.bat.travelagency.service.CityService;
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
public class CityController implements CityApi {

    private final CityService cityService;
    private final CityAssembler cityAssembler;

    @Override
    public CityModel getCity(String name) {
        log.info("getCity: name {}", name);
        CityDto city = cityService.getCity(name);
        return cityAssembler.toModel(city);
    }

    @Override
    public List<CityModel> getAll() {
        List<CityDto> addressDtoList = cityService.getAll();
        return cityAssembler.modelList(addressDtoList);
    }

    @Override
    public CityModel createCity(CityDto cityDto) {
        log.info("createCity: name {}", cityDto.getName());
        CityDto city = cityService.createCity(cityDto);
        return cityAssembler.toModel(city);
    }

    @Override
    public CityModel updateCity(String name, CityDto cityDto) {
        log.info("updateCity: name {}", name);
        CityDto city = cityService.updateCity(name, cityDto);
        return cityAssembler.toModel(city);
    }

    @Override
    public ResponseEntity<Void> deleteCity(String name) {
        log.info("deleteCity: name {}", name);
        cityService.deleteCity(name);
        return ResponseEntity.noContent().build();
    }
}
