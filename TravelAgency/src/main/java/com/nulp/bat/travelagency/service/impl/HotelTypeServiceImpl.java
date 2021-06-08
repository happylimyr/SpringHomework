package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.HotelTypeDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Country;
import com.nulp.bat.travelagency.model.HotelType;
import com.nulp.bat.travelagency.repository.HotelTypeRepository;
import com.nulp.bat.travelagency.service.HotelTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelTypeServiceImpl implements HotelTypeService {

    private final HotelTypeRepository hotelTypeRepository;


    @Override
    public HotelTypeDto getHotelType(String name) {
        log.info("getting hotel type from database by name {}", name);
        HotelType hotelType = hotelTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapHotelTypeToHotelTypeDto(hotelType);
    }

    @Override
    public List<HotelTypeDto> getAll() {
        return hotelTypeRepository.findAll().stream().map(this::mapHotelTypeToHotelTypeDto).collect(Collectors.toList());

    }

    private HotelTypeDto mapHotelTypeToHotelTypeDto(HotelType hotelType) {
        return HotelTypeDto.builder()
                .name(hotelType.getName())
                .build();
    }

    @Override
    public HotelTypeDto createHotelType(HotelTypeDto hotelTypeDto) {
        log.info("creating hotel type in database: {}", hotelTypeDto);
        HotelType hotelType = mapHotelTypeDtoToHotelType(hotelTypeDto);
        hotelType = hotelTypeRepository.save(hotelType);
        return mapHotelTypeToHotelTypeDto(hotelType);
    }

    private HotelType mapHotelTypeDtoToHotelType(HotelTypeDto hotelTypeDto) {
        return HotelType.builder()
                .name(hotelTypeDto.getName())
                .build();
    }

    @Override
    public HotelTypeDto updateHotelType(String name, HotelTypeDto hotelTypeDto) {
        log.info("updating hotel type in database: {}", hotelTypeDto);
        HotelType hotelType = mapHotelTypeDtoToHotelType(hotelTypeDto);
        HotelType hotelTypeFromDB = hotelTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        hotelTypeRepository.delete(hotelTypeFromDB);
        hotelType = hotelTypeRepository.save(hotelType);
        return mapHotelTypeToHotelTypeDto(hotelType);
    }

    @Override
    public void deleteHotelType(String name) {
        log.info("deleting hotel type in database by name {}", name);
        HotelType hotelType = hotelTypeRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        hotelTypeRepository.delete(hotelType);

    }
}
