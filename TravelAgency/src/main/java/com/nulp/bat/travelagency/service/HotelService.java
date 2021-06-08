package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.HotelDto;
import com.nulp.bat.travelagency.dto.PersonalDataDto;

import java.util.List;

public interface HotelService {
    HotelDto getHotel(String name);

    List<HotelDto> getAll();

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto updateHotel(String name, HotelDto hotelDto);

    void deleteHotel(String name);
}
