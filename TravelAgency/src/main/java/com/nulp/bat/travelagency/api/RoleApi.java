package com.nulp.bat.travelagency.api;
import com.nulp.bat.travelagency.controller.model.RoleModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.RoleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "User management API")
@RequestMapping("/api/v1/role")
public interface RoleApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", paramType = "path", required = true, value = "Role"),
    })
    @ApiOperation("Get role")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{role}")
    RoleModel getRole(@PathVariable String role);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<RoleModel> getAll();

    @ApiOperation("Create role")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RoleModel createRole(@Valid @RequestBody RoleDto roleDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", paramType = "path", required = true, value = "Role"),
    })
    @ApiOperation("Update role")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{role}")
    RoleModel updateRole(@PathVariable String role, @RequestBody RoleDto roleDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", paramType = "path", required = true, value = "Role"),
    })
    @ApiOperation("Delete role")
    @RequestMapping(value = "/{role}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRole(@PathVariable String role);
}
