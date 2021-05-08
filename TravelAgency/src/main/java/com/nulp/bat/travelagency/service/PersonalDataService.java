package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.PersonalDataDto;

public interface PersonalDataService {

    PersonalDataDto getPersonalData(String email);

    PersonalDataDto createPersonalData(PersonalDataDto personalDataDto);

    PersonalDataDto updatePersonalData(String email, PersonalDataDto personalDataDto);

    void deletePersonalData(String email);

}
