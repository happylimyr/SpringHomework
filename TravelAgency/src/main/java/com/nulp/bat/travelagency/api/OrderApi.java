package com.nulp.bat.travelagency.api;

import com.nulp.bat.travelagency.controller.model.OrderModel;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.OrderDto;
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
@RequestMapping("/api/v1/order")
public interface OrderApi {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderName", paramType = "path", required = true, value = "orderName"),
    })
    @ApiOperation("Get order")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{orderName}")
        //address -> name
    OrderModel getOrder(@PathVariable String orderName);

    @ApiOperation("Get order by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{idOrder}")
    OrderModel findById(@PathVariable Long idOrder);

    @ApiOperation("Get all orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<OrderModel> getAllOrders();

    @ApiOperation("Create order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    OrderModel createOrder(@Valid @RequestBody OrderDto orderDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderName", paramType = "path", required = true, value = "orderName"),
    })
    @ApiOperation("Update order")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{orderName}")
        //address -> name
    OrderModel updateOrder(@PathVariable String orderName, @RequestBody OrderDto orderDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderName", paramType = "path", required = true, value = "orderName"),
    })
    @ApiOperation("Delete order")
    @RequestMapping(value = "/{orderName}", method = RequestMethod.DELETE)
        //address -> name
    ResponseEntity<Void> deleteOrder(@PathVariable String orderName); @ApiImplicitParams({

            @ApiImplicitParam(name = "orderName", paramType = "path", required = true, value = "orderName"),
    })
    @ApiOperation("Delete order by id")
    @RequestMapping(value = "/id/{idOrder}", method = RequestMethod.DELETE)
        //address -> name
    ResponseEntity<Void> deleteOrderById(@PathVariable Long idOrder);
}
