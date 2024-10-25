package org.example.kafkaproject.orderservice.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.example.kafkaproject.orderservice.dtos.OrderDTO;
import org.example.kafkaproject.orderservice.entities.OrderProduct;
import org.example.kafkaproject.orderservice.entities.Orders;
import org.example.kafkaproject.orderservice.event.OrderCreatedEvent;
import org.example.kafkaproject.orderservice.repositories.OrdersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final KafkaTemplate<Long, OrderCreatedEvent> kafkaTemplate;

    private final OrdersRepo ordersRepo;

    private final ModelMapper modelMapper;

    @Value("${kafka.topic.user-random-topic}")
    private String KAFKA_ORDER_CREATED_TOPIC;

    public OrderDTO saveOrder(Orders order){
        for(OrderProduct orderProduct : order.getOrderedItems()){
            orderProduct.setOrders(order);
        }
        Orders savedOrder = ordersRepo.save(order);
        OrderCreatedEvent orderCreatedEvent = modelMapper.map(savedOrder,OrderCreatedEvent.class);
        kafkaTemplate.send(KAFKA_ORDER_CREATED_TOPIC,savedOrder.getOrderId(),orderCreatedEvent);
        return modelMapper.map(savedOrder, OrderDTO.class);
    }

}
