package com.nulp.bat.travelagency.service;

import com.nulp.bat.travelagency.dto.RoleDto;

public interface RoleService {
    RoleDto getRole(String role);

    RoleDto createRole(RoleDto roleDto);

    RoleDto updateRole(String role, RoleDto roleDto);

    void deleteRole(String role);
}
