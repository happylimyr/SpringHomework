package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.CountryModel;
import com.nulp.bat.travelagency.controller.model.HotelTypeModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.CountryDto;
import com.nulp.bat.travelagency.dto.HotelTypeDto;
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
@RequestMapping("/api/v1/hoteltype")
public interface HotelTypeApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "HotelType"),
    })
    @ApiOperation("Get HotelType")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")      //address -> name
    HotelTypeModel getHotelType(@PathVariable String name);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<HotelTypeModel> getAll();

    @ApiOperation("Create HotelType")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    HotelTypeModel createHotelType(@Valid @RequestBody HotelTypeDto hotelTypeDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "HotelType"),
    })
    @ApiOperation("Update HotelType")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")      //address -> name
    HotelTypeModel updateHotelType(@PathVariable String name, @RequestBody HotelTypeDto hotelTypeDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "HotelType"),
    })
    @ApiOperation("Delete HotelType")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)   //address -> name
    ResponseEntity<Void> deleteHotelType(@PathVariable String name);
}
