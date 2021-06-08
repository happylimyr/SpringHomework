package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.HotelDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Address;
import com.nulp.bat.travelagency.model.City;
import com.nulp.bat.travelagency.model.Country;
import com.nulp.bat.travelagency.model.Hotel;
import com.nulp.bat.travelagency.repository.AddressRepository;
import com.nulp.bat.travelagency.repository.CityRepository;
import com.nulp.bat.travelagency.repository.CountryRepository;
import com.nulp.bat.travelagency.repository.HotelRepository;
import com.nulp.bat.travelagency.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public HotelDto getHotel(String name) {
        log.info("getting hotel from database by name {}", name);
        Hotel hotel = hotelRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapHotelToHotelDto(hotel);
    }

    @Override
    public List<HotelDto> getAll() {
        return hotelRepository.findAll().stream().map(this::mapHotelToHotelDto).collect(Collectors.toList());
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        log.info("creating hotel in database: {}", hotelDto);
        Hotel hotel = mapHotelDtoToHotel(hotelDto);
        hotel = hotelRepository.save(hotel);
        return mapHotelToHotelDto(hotel);
    }

    @Override
    public HotelDto updateHotel(String name, HotelDto hotelDto) {
        log.info("updating hotel in database: {}", hotelDto);
        Hotel hotel = mapHotelDtoToHotel(hotelDto);
        Hotel hotelFromDB = hotelRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        hotelRepository.delete(hotelFromDB);
        hotel = hotelRepository.save(hotel);
        return mapHotelToHotelDto(hotel);
    }

    @Override
    public void deleteHotel(String name) {
        log.info("deleting hotel in database by name {}", name);
        Hotel hotel = hotelRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        hotelRepository.delete(hotel);

    }

    private HotelDto mapHotelToHotelDto(Hotel hotel) {
        return HotelDto.builder()
                .name(hotel.getName())
                .address(hotel.getAddress())
                .hotelType(hotel.getHotelType())
                .build();
    }

    private Hotel mapHotelDtoToHotel(HotelDto hotelDto) {

        hotelDto.getAddress().getCity().setCountry(countryRepository.findByName(hotelDto.getAddress().getCity().getCountry().getName()).orElseGet(() -> {
            getSession().save(hotelDto.getAddress().getCity().getCountry());
            return hotelDto.getAddress().getCity().getCountry();
        }));

        hotelDto.getAddress().setCity(cityRepository.findByName(hotelDto.getAddress().getCity().getName()).orElseGet(() -> {
            getSession().save(hotelDto.getAddress().getCity());
            return hotelDto.getAddress().getCity();
        }));

        hotelDto.setAddress(addressRepository.findByName(hotelDto.getAddress().getName()).orElseGet(() -> {
            getSession().save(hotelDto.getAddress());
            return hotelDto.getAddress();
        }));

        return Hotel.builder()
                .name(hotelDto.getName())
                .address(hotelDto.getAddress())
//                .address(hotelDto.getAddress().getCity()
//               .address(hotelDto.getAddress())
                .hotelType(hotelDto.getHotelType())
                .build();
    }
}
