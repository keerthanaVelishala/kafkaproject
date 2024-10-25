package org.example.kafkaproject.orderservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproject.orderservice.dtos.OrderDTO;
import org.example.kafkaproject.orderservice.entities.Orders;
import org.example.kafkaproject.orderservice.repositories.OrdersRepo;
import org.example.kafkaproject.orderservice.services.OrdersService;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    private final ModelMapper modelMapper;
    @PostMapping("/placeorder")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO savedOrder = ordersService.saveOrder(modelMapper.map(orderDTO, Orders.class));
        return new ResponseEntity<>(savedOrder, HttpStatusCode.valueOf(201));
    }
}
