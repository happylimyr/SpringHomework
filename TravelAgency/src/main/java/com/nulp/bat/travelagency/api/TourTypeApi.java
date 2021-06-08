package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.TourTypeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Tour type management API")
@RequestMapping("/api/v1/tourtype")
public interface TourTypeApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "TourType"),
    })
    @ApiOperation("Get TourType")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{name}")
    TourTypeModel getTourType(@PathVariable String name);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<TourTypeModel> getAll();

    @ApiOperation("Create TourType")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TourTypeModel createTourType(@Valid @RequestBody TourTypeDto tourTypeDto);


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "TourType"),
    })
    @ApiOperation("Update TourType")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{name}")
    TourTypeModel updateTourType(@PathVariable String name, @RequestBody TourTypeDto tourTypeDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "path", required = true, value = "TourType"),
    })
    @ApiOperation("Delete TourType")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTourType(@PathVariable String name);
}
