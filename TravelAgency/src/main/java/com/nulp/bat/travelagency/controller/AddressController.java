package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.AddressApi;
import com.nulp.bat.travelagency.controller.assembler.AddressAssembler;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.service.AddressService;
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
public class AddressController implements AddressApi {

    private final AddressService addressService;
    private final AddressAssembler addressAssembler;

    @Override
    public AddressModel getAddress(String name) {
        log.info("getAddress: name {}", name);
        AddressDto address = addressService.getAddress(name);
        return addressAssembler.toModel(address);
    }

    @Override
    public List<AddressModel> getAll() {
        List<AddressDto> addressDtoList = addressService.getAll();
        return addressAssembler.modelList(addressDtoList);
    }

    @Override
    public AddressModel createAddress(AddressDto addressDto) {
        log.info("createAddress: name {}", addressDto.getName());
        AddressDto address = addressService.createAddress(addressDto);
        return addressAssembler.toModel(address);
    }

    @Override
    public AddressModel updateAddress(String name, AddressDto addressDto) {
        log.info("updateAddress: name {}", name);
        AddressDto address = addressService.updateAddress(name, addressDto);
        return addressAssembler.toModel(address);
    }

    @Override
    public ResponseEntity<Void> deleteAddress(String name) {
        log.info("deleteAddress: name {}", name);
        addressService.deleteAddress(name);
        return ResponseEntity.noContent().build();
    }
}
