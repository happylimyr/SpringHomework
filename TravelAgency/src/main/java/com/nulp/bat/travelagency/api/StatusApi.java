package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.StatusModel;
import com.nulp.bat.travelagency.controller.model.TourTypeModel;
import com.nulp.bat.travelagency.dto.StatusDto;
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
@RequestMapping("/api/v1/status")
public interface StatusApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", paramType = "path", required = true, value = "Status"),
    })
    @ApiOperation("Get status")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{status}")
    StatusModel getStatus(@PathVariable String status);

    @ApiOperation("Get all ")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<StatusModel> getAll();

    @ApiOperation("Create status")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    StatusModel createStatus(@Valid @RequestBody StatusDto statusDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", paramType = "path", required = true, value = "Status"),
    })
    @ApiOperation("Update status")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{status}")
    StatusModel updateStatus(@PathVariable String status, @RequestBody StatusDto statusDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", paramType = "path", required = true, value = "Status"),
    })
    @ApiOperation("Delete status")
    @RequestMapping(value = "/{status}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteStatus(@PathVariable String status);
}
