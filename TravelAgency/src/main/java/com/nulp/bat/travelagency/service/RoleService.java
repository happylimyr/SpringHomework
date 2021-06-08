package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getRole(String role);

    List<RoleDto> getAll();

    RoleDto createRole(RoleDto roleDto);

    RoleDto updateRole(String role, RoleDto roleDto);

    void deleteRole(String role);
}
