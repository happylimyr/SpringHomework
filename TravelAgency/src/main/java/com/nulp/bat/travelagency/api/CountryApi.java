package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.CityModel;
import com.nulp.bat.travelagency.controller.model.CountryModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.CityDto;
import com.nulp.bat.travelagency.dto.CountryDto;
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
@RequestMapping("/api/v1/country")
public interface CountryApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Country"),
    })
    @ApiOperation("Get country")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")      //address -> name
    CountryModel getCountry(@PathVariable String name);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CountryModel> getAll();

    @ApiOperation("Create country")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CountryModel createCountry(@Valid @RequestBody CountryDto countryDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Country"),
    })
    @ApiOperation("Update country")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")      //address -> name
    CountryModel updateCountry(@PathVariable String name, @RequestBody CountryDto countryDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Country"),
    })
    @ApiOperation("Delete country")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)   //address -> name
    ResponseEntity<Void> deleteCountry(@PathVariable String name);
}
