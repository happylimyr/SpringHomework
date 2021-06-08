package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto getOrder(String orderName);

    List<OrderDto> getAllOrders();

    OrderDto findById(Long idOrder);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(String orderName, OrderDto orderDto);

    void deleteOrder(String orderName);

    void deleteOrderById(Long idOrder);

}
