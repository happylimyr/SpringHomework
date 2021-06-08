package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.TourDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Tour management API")
@RequestMapping("/api/v1/tour")
public interface TourApi {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tour", paramType = "path", required = true, value = "tour"),
    })
    @ApiOperation("Get tour")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{tour}")
    TourModel getTour(@PathVariable String tour);

    //    @ApiImplicitParams({
//            @ApiImplicitParam(name = "tour", paramType = "path", required = true, value = "tour"),
//    })
    @ApiOperation("Get all tours")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<TourModel> getAllTour();

    @ApiOperation("Create tour")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TourModel createTour(@Valid @RequestBody TourDto tourDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "tour", paramType = "path", required = true, value = "tour"),
    })
    @ApiOperation("Update tour")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{tour}")
    TourModel updateTour(@PathVariable String tour, @RequestBody TourDto tourDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "tour", paramType = "path", required = true, value = "tour"),
    })
    @ApiOperation("Delete tour")
    @RequestMapping(value = "/{tour}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTour(@PathVariable String tour);

    @ApiOperation("Delete tour by id")
    @RequestMapping(value = "/id/{idTour}", method = RequestMethod.DELETE)
        //address -> name
    ResponseEntity<Void> deleteById(@PathVariable Long idOrder);
}
