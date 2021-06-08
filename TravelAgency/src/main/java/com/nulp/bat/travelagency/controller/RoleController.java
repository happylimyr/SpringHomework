package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.RoleApi;
import com.nulp.bat.travelagency.controller.assembler.RoleAssembler;
import com.nulp.bat.travelagency.controller.model.RoleModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.RoleDto;
import com.nulp.bat.travelagency.service.RoleService;
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
public class RoleController implements RoleApi {

    private final RoleService roleService;
    private final RoleAssembler roleAssembler;

    @Override
    public RoleModel getRole(String role) {
        log.info("getRole: role {}", role);
        RoleDto roles = roleService.getRole(role);
        return roleAssembler.toModel(roles);
    }

    @Override
    public List<RoleModel> getAll() {
        List<RoleDto> addressDtoList = roleService.getAll();
        return roleAssembler.modelList(addressDtoList);
    }

    @Override
    public RoleModel createRole(RoleDto roleDto) {
        log.info("createRole: role name {}", roleDto.getRole());
        RoleDto roles = roleService.createRole(roleDto);
        return roleAssembler.toModel(roles);
    }

    @Override
    public RoleModel updateRole(String role, RoleDto roleDto) {
        log.info("updateRole: role name {}", role);
        RoleDto roles = roleService.updateRole(role, roleDto);
        return roleAssembler.toModel(roles);
    }

    @Override
    public ResponseEntity<Void> deleteRole(String role) {
        log.info("deleteRole: role name {}", role);
        roleService.deleteRole(role);
        return ResponseEntity.noContent().build();
    }
}
