package org.example.kafkaproject.orderservice.event;

import lombok.Data;
import org.example.kafkaproject.orderservice.dtos.ProductDTO;

import java.util.List;

@Data
public class OrderCreatedEvent {
    private List<ProductDTO> orderedItems;
}
