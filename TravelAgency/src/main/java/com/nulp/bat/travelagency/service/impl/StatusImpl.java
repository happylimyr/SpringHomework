package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.StatusDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Status;
import com.nulp.bat.travelagency.repository.StatusRepository;
import com.nulp.bat.travelagency.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Override
    public StatusDto getStatus(String name) {
        log.info("getting status {}", name);
        Status statuses = statusRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        return mapStatusToStatusDto(statuses);
    }

    @Override
    public List<StatusDto> getAll() {
        return statusRepository.findAll().stream().map(this::mapStatusToStatusDto).collect(Collectors.toList());

    }

    @Override
    public StatusDto createStatus(StatusDto statusDto) {
        log.info("creating status in database: {}", statusDto);
        Status status = mapStatusDtoToStatus(statusDto);
        status = statusRepository.save(status);
        return mapStatusToStatusDto(status);
    }

    @Override
    public StatusDto updateStatus(String name, StatusDto statusDto) {
        log.info("updating status in database: {}", statusDto);
        Status statuses = mapStatusDtoToStatus(statusDto);
        Status statusFromDB = statusRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        statusRepository.delete(statusFromDB);
        statuses = statusRepository.save(statuses);
        return mapStatusToStatusDto(statuses);
    }

    @Override
    public void deleteStatus(String name) {
        log.info("deleting status in database by status name {}", name);
        Status statuses = statusRepository.findByName(name)
                .orElseThrow(NotFoundException::new);
        statusRepository.delete(statuses);
    }

    private StatusDto mapStatusToStatusDto(Status statuses) {
        return StatusDto.builder()
                .name(statuses.getName())
                .description(statuses.getDescription())
                .build();
    }

    private Status mapStatusDtoToStatus(StatusDto statusDto) {
        return Status.builder()
                .name(statusDto.getName())
                .description(statusDto.getDescription())
                .build();
    }
}
