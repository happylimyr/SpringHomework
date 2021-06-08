package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.PersonalDataModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
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
@RequestMapping("/api/v1/personaldata")
public interface PersonalDataApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
    })
    @ApiOperation("Get personalData")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    PersonalDataModel getPersonalData(@PathVariable String email);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<PersonalDataModel> getAll();

    @ApiOperation("Create personalData")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    PersonalDataModel createPersonalData(@Valid @RequestBody PersonalDataDto personalDataDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
    })
    @ApiOperation("Update personalData")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    PersonalDataModel updatePersonalData(@PathVariable String email, @RequestBody PersonalDataDto personalDataDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email"),
    })
    @ApiOperation("Delete personalData")
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePersonalData(@PathVariable String email);
}
