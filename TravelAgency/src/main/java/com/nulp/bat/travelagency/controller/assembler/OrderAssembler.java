package com.nulp.bat.travelagency.controller.assembler;

import com.nulp.bat.travelagency.controller.OrderController;
import com.nulp.bat.travelagency.controller.model.OrderModel;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.dto.OrderDto;
import com.nulp.bat.travelagency.dto.TourDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {
    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    public List<OrderModel> orderModelList(List<OrderDto> entities) {
        return StreamSupport.stream(entities.spliterator(), true).map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public OrderModel toModel(OrderDto entity) {
        OrderModel orderModel = new OrderModel(entity);

        Link get = linkTo(methodOn(OrderController.class).getOrder(entity.getOrderName())).withRel("get");
        Link create = linkTo(methodOn(OrderController.class).createOrder(entity)).withRel("create");
        Link update = linkTo(methodOn(OrderController.class).updateOrder(entity.getOrderName(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(OrderController.class).deleteOrder(entity.getOrderName()))
                .withRel("delete");

        orderModel.add(get, create, update, delete);

        return orderModel;
    }
}
