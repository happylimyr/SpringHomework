package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.PersonalDataApi;
import com.nulp.bat.travelagency.controller.assembler.PersonalDataAssembler;
import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.repository.PersonalDataRepository;
import com.nulp.bat.travelagency.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonalDataController implements PersonalDataApi {

    private final PersonalDataService personalDataService;
    private final PersonalDataAssembler personalDataAssembler;

    @Override
    public PersonalDataModel getPersonalData(String email) {
        log.info("getPersonalData: email {}", email);
        PersonalDataDto personalData = personalDataService.getPersonalData(email);
        return personalDataAssembler.toModel(personalData);
    }

    @Override
    public PersonalDataModel createPersonalData(PersonalDataDto personalDataDto) {
        log.info("createPersonalData: email {}", personalDataDto.getEmail());
        PersonalDataDto personalData = personalDataService.createPersonalData(personalDataDto);
        return personalDataAssembler.toModel(personalData);
    }

    @Override
    public PersonalDataModel updatePersonalData(String email, PersonalDataDto personalDataDto) {
        log.info("updatePersonalData: email {}", email);
        PersonalDataDto personalData = personalDataService.updatePersonalData(email, personalDataDto);
        return personalDataAssembler.toModel(personalData);
    }

    @Override
    public ResponseEntity<Void> deletePersonalData(String email) {
        log.info("deletePersonalData: email {}", email);
        personalDataService.deletePersonalData(email);
        return ResponseEntity.noContent().build();
    }
}
