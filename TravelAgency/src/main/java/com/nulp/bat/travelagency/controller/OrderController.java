package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.OrderApi;
import com.nulp.bat.travelagency.controller.assembler.OrderAssembler;
import com.nulp.bat.travelagency.controller.model.OrderModel;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.OrderDto;
import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController implements OrderApi {

    private final OrderAssembler orderAssembler;
    private final OrderService orderService;

    @Override
    public OrderModel getOrder(String orderName) {
        log.info("getOrder: order {}", orderName);
        OrderDto order = orderService.getOrder(orderName);
        return orderAssembler.toModel(order);
    }

    @Override
    public OrderModel findById(Long idOrder) {
        OrderDto order = orderService.findById(idOrder);
        return orderAssembler.toModel(order);
    }

    public List<OrderModel> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();
        return orderAssembler.orderModelList(orderDtos);
    }

    @Override
    public OrderModel createOrder(OrderDto orderDto) {
        log.info("createOrder: order {}", orderDto.getOrderName());
        OrderDto order = orderService.createOrder(orderDto);
        return orderAssembler.toModel(order);
    }

    @Override
    public OrderModel updateOrder(String orderName, OrderDto orderDto) {
        log.info("updateOrder: order {}", orderName);
        OrderDto order = orderService.updateOrder(orderName, orderDto);
        return orderAssembler.toModel(order);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(String orderName) {
        log.info("deleteOrder: order {}", orderName);
        orderService.deleteOrder(orderName);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteOrderById(Long idOrder) {
        orderService.deleteOrderById(idOrder);
        return ResponseEntity.noContent().build();
    }
}
