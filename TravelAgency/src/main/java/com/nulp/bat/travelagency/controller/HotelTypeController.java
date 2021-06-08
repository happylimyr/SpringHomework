package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.HotelTypeApi;
import com.nulp.bat.travelagency.controller.assembler.HotelTypeAssembler;
import com.nulp.bat.travelagency.controller.model.HotelTypeModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.HotelTypeDto;
import com.nulp.bat.travelagency.service.HotelTypeService;
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
public class HotelTypeController implements HotelTypeApi {

    private final HotelTypeService hotelTypeService;
    private final HotelTypeAssembler hotelTypeAssembler;

    @Override
    public HotelTypeModel getHotelType(String name) {
        log.info("getHotelType: name {}", name);
        HotelTypeDto hotelType = hotelTypeService.getHotelType(name);
        return hotelTypeAssembler.toModel(hotelType);
    }

    @Override
    public List<HotelTypeModel> getAll() {
        List<HotelTypeDto> addressDtoList = hotelTypeService.getAll();
        return hotelTypeAssembler.modelList(addressDtoList);
    }

    @Override
    public HotelTypeModel createHotelType(HotelTypeDto hotelTypeDto) {
        log.info("createHotelType: name {}", hotelTypeDto.getName());
        HotelTypeDto hotelType = hotelTypeService.createHotelType(hotelTypeDto);
        return hotelTypeAssembler.toModel(hotelType);
    }

    @Override
    public HotelTypeModel updateHotelType(String name, HotelTypeDto hotelTypeDto) {
        log.info("updateHotelType: name {}", name);
        HotelTypeDto hotelType = hotelTypeService.updateHotelType(name, hotelTypeDto);
        return hotelTypeAssembler.toModel(hotelType);
    }

    @Override
    public ResponseEntity<Void> deleteHotelType(String name) {
        log.info("deleteHotelType: name {}", name);
        hotelTypeService.deleteHotelType(name);
        return ResponseEntity.noContent().build();
    }
}
