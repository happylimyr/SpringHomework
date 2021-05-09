package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.AddressDto;

public interface AddressService {

    AddressDto getAddress(String name);

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(String name, AddressDto addressDto);

    void deleteAddress(String name);

}
