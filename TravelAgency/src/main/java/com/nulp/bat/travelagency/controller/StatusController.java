package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.StatusApi;
import com.nulp.bat.travelagency.controller.assembler.StatusAssembler;
import com.nulp.bat.travelagency.controller.model.StatusModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.StatusDto;
import com.nulp.bat.travelagency.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController implements StatusApi {

    private final StatusService statusService;
    private final StatusAssembler statusAssembler;

    @Override
    public StatusModel getStatus(String status) {
        log.info("getStatus: status {}", status);
        StatusDto statusDto = statusService.getStatus(status);
        return statusAssembler.toModel(statusDto);
    }

    @Override
    public List<StatusModel> getAll() {
        List<StatusDto> addressDtoList = statusService.getAll();
        return statusAssembler.modelList(addressDtoList);
    }

    @Override
    public StatusModel createStatus(StatusDto statusDto) {
        log.info("createStatus: status name {}", statusDto.getName());
        StatusDto statuses = statusService.createStatus(statusDto);
        return statusAssembler.toModel(statuses);
    }

    @Override
    public StatusModel updateStatus(String status, StatusDto statusDto) {
        log.info("updateStatus: status name {}", status);
        StatusDto statuses = statusService.updateStatus(status, statusDto);
        return statusAssembler.toModel(statuses);
    }

    @Override
    public ResponseEntity<Void> deleteStatus(String status) {
        log.info("deleteStatus: status name {}", status);
        statusService.deleteStatus(status);
        return ResponseEntity.noContent().build();
    }
}
