package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.HotelApi;
import com.nulp.bat.travelagency.controller.assembler.HotelAssembler;
import com.nulp.bat.travelagency.controller.model.HotelModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.HotelDto;
import com.nulp.bat.travelagency.service.HotelService;
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
public class HotelController implements HotelApi {

    private final HotelService hotelService;
    private final HotelAssembler hotelAssembler;

    @Override
    public HotelModel getHotel(String name) {
        log.info("getHotel: name {}", name);
        HotelDto hotel = hotelService.getHotel(name);
        return hotelAssembler.toModel(hotel);
    }

    @Override
    public List<HotelModel> getAll() {
        List<HotelDto> addressDtoList = hotelService.getAll();
        return hotelAssembler.modelList(addressDtoList);
    }

    @Override
    public HotelModel createHotel(HotelDto hotelDto) {
        log.info("createHotel: name {}", hotelDto.getName());
        HotelDto hotel = hotelService.createHotel(hotelDto);
        return hotelAssembler.toModel(hotel);
    }

    @Override
    public HotelModel updateHotel(String name, HotelDto hotelDto) {
        log.info("updateHotel: name {}", name);
        HotelDto hotel = hotelService.updateHotel(name, hotelDto);
        return hotelAssembler.toModel(hotel);
    }

    @Override
    public ResponseEntity<Void> deleteHotel(String name) {
        log.info("deleteHotel: name {}", name);
        hotelService.deleteHotel(name);
        return ResponseEntity.noContent().build();
    }
}
