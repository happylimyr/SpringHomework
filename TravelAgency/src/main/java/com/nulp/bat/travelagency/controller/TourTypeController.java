package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.TourTypeApi;
import com.nulp.bat.travelagency.controller.assembler.TourTypeAssembler;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.TourTypeDto;
import com.nulp.bat.travelagency.service.TourTypeService;
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
public class TourTypeController implements TourTypeApi {

    private final TourTypeService tourTypeService;
    private final TourTypeAssembler tourTypeAssembler;

    @Override
    public TourTypeModel getTourType(String name) {
        log.info("getTourType: tour type {}", name);
        TourTypeDto tourTypeDto = tourTypeService.getTourType(name);
        return tourTypeAssembler.toModel(tourTypeDto);
    }

    @Override
    public List<TourTypeModel> getAll() {
        List<TourTypeDto> addressDtoList = tourTypeService.getAll();
        return tourTypeAssembler.modelList(addressDtoList);
    }

    @Override
    public TourTypeModel createTourType(TourTypeDto tourTypeDto) {
        log.info("createTourType: TourType  {}", tourTypeDto.getName());
        TourTypeDto statuses = tourTypeService.createTourType(tourTypeDto);
        return tourTypeAssembler.toModel(statuses);
    }

    @Override
    public TourTypeModel updateTourType(String name, TourTypeDto tourTypeDto) {
        log.info("updateTourType: TourType {}", name);
        TourTypeDto statuses = tourTypeService.updateTourType(name,tourTypeDto);
        return tourTypeAssembler.toModel(statuses);    }

    @Override
    public ResponseEntity<Void> deleteTourType(String name) {
        log.info("deleteTourType: type tour name {}", name);
        tourTypeService.deleteTourType(name);
        return ResponseEntity.noContent().build();
    }
}
