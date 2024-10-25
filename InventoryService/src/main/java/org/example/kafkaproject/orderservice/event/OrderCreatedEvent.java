package org.example.kafkaproject.orderservice.event;

import lombok.Data;
import org.example.kafkaproject.inventoryservice.dtos.ProductDTO;

import java.util.List;

@Data
public class OrderCreatedEvent {
    private List<ProductDTO> orderedItems;
}
