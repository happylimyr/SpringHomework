package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.AddressApi;
import com.nulp.bat.travelagency.controller.assembler.AddressAssembler;
import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
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
