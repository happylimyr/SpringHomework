package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.OrderDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.Order;
import com.nulp.bat.travelagency.repository.*;
import com.nulp.bat.travelagency.service.OrderService;
import com.nulp.bat.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final HotelRepository hotelRepository;
    private final TourRepository tourRepository;

    private final TourService tourService;


    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public OrderDto getOrder(String orderName) {
        log.info("getting order from database by name {}", orderName);
        Order order = orderRepository.findByOrderName(orderName)
                .orElseThrow(NotFoundException::new);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto findById(Long idOrder) {
        log.info("getting order from database by id {}", idOrder);
        Order order = orderRepository.findById(idOrder)
                .orElseThrow(NotFoundException::new);
        return mapOrderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapOrderToOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("creating order in database: {}", orderDto);
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.save(order);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(String orderName, OrderDto orderDto) {
        log.info("updating order data in database: {}", orderDto);
        Order order = mapOrderDtoToOrder(orderDto);
        Order orderFromDB = orderRepository.findByOrderName(orderName)
                .orElseThrow(NotFoundException::new);
        orderRepository.delete(orderFromDB);
        order = orderRepository.save(order);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(String orderName) {
        log.info("deleting order in database by name {}", orderName);
        Order order = orderRepository.findByOrderName(orderName)
                .orElseThrow(NotFoundException::new);
        orderRepository.delete(order);
    }

    @Override
    public void deleteOrderById(Long idOrder) {
        Order order = orderRepository.findById(idOrder)
                .orElseThrow(NotFoundException::new);
        orderRepository.delete(order);
    }

    private OrderDto mapOrderToOrderDto(Order order) {


        return OrderDto.builder()
                .orderName(order.getOrderName())
                .discount(order.getDiscount())
                .countOfMembers(order.getCountOfMembers())
//                .user(order.getUser())
                .status(order.getStatus())
                .tour(order.getTour())
                .user(order.getUser())
                .build();
    }

    private Order mapOrderDtoToOrder(OrderDto orderDto) {

        orderDto.setStatus(statusRepository.findByName(orderDto.getStatus().getName()).orElseGet(() -> {
            getSession().save(orderDto.getStatus());
            return orderDto.getStatus();
        }));

        orderDto.getTour().setHotel(hotelRepository.findByName(orderDto.getTour().getHotel().getName()).orElseGet(() -> {
            getSession().save(orderDto.getTour().getHotel());
            return orderDto.getTour().getHotel();
        }));



        orderDto.setTour(tourRepository.findByName(orderDto.getTour().getName()).orElseGet(() -> {
            getSession().save(orderDto.getTour());
            return orderDto.getTour();
        }));

        orderDto.setUser(userRepository.findByloginUser(orderDto.getUser().getLoginUser()).orElseGet(() -> {
            getSession().save(orderDto.getUser());
            return orderDto.getUser();
        }));


//        orderDto.setUser(userRepository.findByIdUser(orderDto.getUser().getIdUser()).orElseGet(()->{
//            getSession().save(orderDto.getUser());
//            return orderDto.getUser();
//        }));
        userRepository.findById(orderDto.getUser().getIdUser());
        tourRepository.findById(orderDto.getTour().getIdTour());
        statusRepository.findById(orderDto.getStatus().getIdStatus());


        return Order.builder()
                .orderName(orderDto.getOrderName())
                .discount(orderDto.getDiscount())
                .countOfMembers(orderDto.getCountOfMembers())
                .user(orderDto.getUser())
                .status(orderDto.getStatus())
                .tour(orderDto.getTour())
                .build();
    }
}
