package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Address;
import com.nulp.bat.travelagency.repository.AddressRepository;
import com.nulp.bat.travelagency.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public AddressDto getAddress(String name) {
        log.info("getting address from database by name {}", name);
        Address address = addressRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapAddressToAddressDto(address);
    }


    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        log.info("creating address in database: {}", addressDto);
        Address address = mapAddressDtoToAddress(addressDto);
        address = addressRepository.save(address);
        return mapAddressToAddressDto(address);
    }

    @Override
    public AddressDto updateAddress(String name, AddressDto addressDto) {
        log.info("updating address in database: {}", addressDto);
        Address address = mapAddressDtoToAddress(addressDto);
        Address addressFromDB = addressRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        addressRepository.delete(addressFromDB);
        address = addressRepository.save(address);
        return mapAddressToAddressDto(address);
    }

    @Override
    public void deleteAddress(String name) {
        log.info("deleting address in database by name {}", name);
        Address address = addressRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        addressRepository.delete(address);
    }

    private AddressDto mapAddressToAddressDto(Address address) {
        return AddressDto.builder()
                .name(address.getName())
                .build();
    }

    private Address mapAddressDtoToAddress(AddressDto addressDto) {
        return Address.builder()
                .name(addressDto.getName())
                .build();
    }
}
