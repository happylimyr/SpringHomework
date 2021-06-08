package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.HotelModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.HotelDto;
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
@RequestMapping("/api/v1/hotel")
public interface HotelApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Hotel"),
    })
    @ApiOperation("Get Hotel")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")      //address -> name
    HotelModel getHotel(@PathVariable String name);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<HotelModel> getAll();

    @ApiOperation("Create Hotel")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    HotelModel createHotel(@Valid @RequestBody HotelDto hotelDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Hotel"),
    })
    @ApiOperation("Update Hotel")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")      //address -> name
    HotelModel updateHotel(@PathVariable String name, @RequestBody HotelDto hotelDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "Hotel"),
    })
    @ApiOperation("Delete Hotel")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)   //address -> name
    ResponseEntity<Void> deleteHotel(@PathVariable String name);
}
