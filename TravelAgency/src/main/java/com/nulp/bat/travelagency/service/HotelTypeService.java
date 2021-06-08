package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.HotelTypeDto;

import java.util.List;

public interface HotelTypeService {
    HotelTypeDto getHotelType(String name);

    List<HotelTypeDto> getAll();

    HotelTypeDto createHotelType(HotelTypeDto hotelTypeDto);

    HotelTypeDto updateHotelType(String name, HotelTypeDto hotelTypeDto);

    void deleteHotelType(String name);
}
