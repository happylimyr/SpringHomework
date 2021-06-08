package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.repository.PersonalDataRepository;
import com.nulp.bat.travelagency.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalDataServiceImpl implements PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    @Override
    public PersonalDataDto getPersonalData(String email) {
        log.info("getting user from database by email {}", email);
        PersonalData personalData = personalDataRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        return mapPersonalDataToPersonalDataDto(personalData);
    }

    @Override
    public List<PersonalDataDto> getAll() {
        return personalDataRepository.findAll().stream().map(this::mapPersonalDataToPersonalDataDto).collect(Collectors.toList());

    }

    @Override
    public PersonalDataDto createPersonalData(PersonalDataDto personalDataDto) {
        log.info("creating personalData in database: {}", personalDataDto);
        PersonalData personalData = mapPersonalDataDtoToPersonalData(personalDataDto);
        personalData = personalDataRepository.save(personalData);
        return mapPersonalDataToPersonalDataDto(personalData);
    }

    @Override
    public PersonalDataDto updatePersonalData(String email, PersonalDataDto personalDataDto) {
        log.info("updating personal data in database: {}", personalDataDto);
        PersonalData personalData = mapPersonalDataDtoToPersonalData(personalDataDto);
        PersonalData personalDataFromDB = personalDataRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        personalDataRepository.delete(personalDataFromDB);
        personalData = personalDataRepository.save(personalData);
        return mapPersonalDataToPersonalDataDto(personalData);
    }

    @Override
    public void deletePersonalData(String email) {
        log.info("deleting user in database by email {}", email);
        PersonalData personalData = personalDataRepository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        personalDataRepository.delete(personalData);
    }

    private PersonalDataDto mapPersonalDataToPersonalDataDto(PersonalData personalData) {
        return PersonalDataDto.builder()
                .firstName(personalData.getFirstName())
                .lastName(personalData.getLastName())
                .email(personalData.getEmail())
                .phone(personalData.getPhone())
                .build();
    }

    private PersonalData mapPersonalDataDtoToPersonalData(PersonalDataDto personalDataDto) {
        return PersonalData.builder()
                .firstName(personalDataDto.getFirstName())
                .lastName(personalDataDto.getLastName())
                .email(personalDataDto.getEmail())
                .phone(personalDataDto.getPhone())
                .build();
    }
}
