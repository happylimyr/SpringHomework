package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Address;
import com.nulp.bat.travelagency.model.City;
import com.nulp.bat.travelagency.repository.AddressRepository;
import com.nulp.bat.travelagency.repository.CityRepository;
import com.nulp.bat.travelagency.repository.CountryRepository;
import com.nulp.bat.travelagency.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public AddressDto getAddress(String name) {
        log.info("getting address from database by name {}", name);
        Address address = addressRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapAddressToAddressDto(address);
    }

    @Override
    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream().map(this::mapAddressToAddressDto).collect(Collectors.toList());

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
                .city(address.getCity())
                .build();
    }

    private Address mapAddressDtoToAddress(AddressDto addressDto) {
        addressDto.getCity().setCountry(countryRepository.findByName(addressDto.getCity().getCountry().getName()).orElseGet(() -> {
            getSession().save(addressDto.getCity().getCountry());
            return addressDto.getCity().getCountry();
        }));

        addressDto.setCity(cityRepository.findByName(addressDto.getCity().getName()).orElseGet(() -> {
            getSession().save(addressDto.getCity());
            return addressDto.getCity();
        }));

//        getSession().save(addressDto.getCity());
        return Address.builder()
                .name(addressDto.getName())
//                .city(cityRepository.findByName(addressDto.getCity()).orElse(new City().builder()
//                        .name(addressDto.getCity())
//                        .build()))
                .city(addressDto.getCity())
                .build();
    }
}
