package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User management API")
@RequestMapping("/api/v1/user")
public interface UserApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User "),
    })
    @ApiOperation("Get user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    UserModel getUser(@PathVariable String login);

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User "),
    })
    @ApiOperation("Update personalData")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    UserModel updateUser(@PathVariable String login, @RequestBody UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "login", paramType = "path", required = true, value = "User "),
    })
    @ApiOperation("Delete personalData")
    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@PathVariable String email);
}
