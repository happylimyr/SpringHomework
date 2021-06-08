package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.RoleDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Role;
import com.nulp.bat.travelagency.repository.RoleRepository;
import com.nulp.bat.travelagency.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public RoleDto getRole(String role) {
        log.info("getting role {}", role);
        Role roles = roleRepository.findByRole(role)
                .orElseThrow(NotFoundException::new);
        return mapRoleToRoleDto(roles);
    }

    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll().stream().map(this::mapRoleToRoleDto).collect(Collectors.toList());

    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        log.info("creating role in database: {}", roleDto);
        Role roles = mapRoleDtoTorole(roleDto);
        roles = roleRepository.save(roles);
        return mapRoleToRoleDto(roles);
    }

    @Override
    public RoleDto updateRole(String role, RoleDto roleDto) {
        log.info("updating role in database: {}", roleDto);
        Role roles = mapRoleDtoTorole(roleDto);
        Role roleFromDB = roleRepository.findByRole(role)
                .orElseThrow(NotFoundException::new);
        roleRepository.delete(roleFromDB);
        roles = roleRepository.save(roles);
        return mapRoleToRoleDto(roles);
    }

    @Override
    public void deleteRole(String role) {
        log.info("deleting role in database by role name {}", role);
        Role roles = roleRepository.findByRole(role)
                .orElseThrow(NotFoundException::new);
        roleRepository.delete(roles);
    }

    private Role mapRoleDtoTorole(RoleDto roleDto) {
        return Role.builder()
                .role(roleDto.getRole())
                .build();
    }

    private RoleDto mapRoleToRoleDto(Role roles) {
        return RoleDto.builder()
                .role(roles.getRole())
                .build();
    }
}
