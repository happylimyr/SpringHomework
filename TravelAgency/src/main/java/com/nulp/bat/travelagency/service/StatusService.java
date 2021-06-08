package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.StatusDto;

import java.util.List;

public interface StatusService {
    StatusDto getStatus(String name);

    List<StatusDto> getAll();

    StatusDto createStatus(StatusDto statusDto);

    StatusDto updateStatus(String name, StatusDto statusDto);

    void deleteStatus(String name);
}
