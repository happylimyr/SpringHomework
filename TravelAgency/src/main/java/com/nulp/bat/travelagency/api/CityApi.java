package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.CityModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.CityDto;
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
@RequestMapping("/api/v1/city")
public interface CityApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "City"),
    })
    @ApiOperation("Get city")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")      //address -> name
    CityModel getCity(@PathVariable String name);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CityModel> getAll();

    @ApiOperation("Create city")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CityModel createCity(@Valid @RequestBody CityDto cityDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "City"),
    })
    @ApiOperation("Update city")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")      //address -> name
    CityModel updateCity(@PathVariable String name, @RequestBody CityDto cityDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "City"),
    })
    @ApiOperation("Delete city")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)   //address -> name
    ResponseEntity<Void> deleteCity(@PathVariable String name);
}
