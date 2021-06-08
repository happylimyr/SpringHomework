package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto getAddress(String name);

    List<AddressDto> getAll();

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(String name, AddressDto addressDto);

    void deleteAddress(String name);

}
