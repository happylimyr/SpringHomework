package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.AddressModel;
import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.dto.AddressDto;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Api(tags = "User management API")
@RequestMapping("/api/v1/address")
public interface AddressApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Address"),
    })
    @ApiOperation("Get address")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")      //address -> name
    AddressModel getAddress(@PathVariable String name);

    @ApiOperation("Create address")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AddressModel createAddress(@Valid @RequestBody AddressDto addressDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Address"),
    })
    @ApiOperation("Update address")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")      //address -> name
    AddressModel updateAddress(@PathVariable String name, @RequestBody AddressDto addressDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Address"),
    })
    @ApiOperation("Delete address")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)   //address -> name
    ResponseEntity<Void> deleteAddress(@PathVariable String name);
}
