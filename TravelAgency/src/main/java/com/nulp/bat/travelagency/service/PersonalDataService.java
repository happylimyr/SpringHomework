package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.PersonalDataDto;

import java.util.List;

public interface PersonalDataService {

    PersonalDataDto getPersonalData(String email);

    List<PersonalDataDto> getAll();

    PersonalDataDto createPersonalData(PersonalDataDto personalDataDto);

    PersonalDataDto updatePersonalData(String email, PersonalDataDto personalDataDto);

    void deletePersonalData(String email);

}
