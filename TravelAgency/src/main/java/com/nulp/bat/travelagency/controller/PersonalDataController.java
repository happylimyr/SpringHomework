package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.PersonalDataApi;
import com.nulp.bat.travelagency.controller.assembler.PersonalDataAssembler;
import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.service.PersonalDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
    public List<PersonalDataModel> getAll() {
        List<PersonalDataDto> addressDtoList = personalDataService.getAll();
        return personalDataAssembler.modelList(addressDtoList);
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
