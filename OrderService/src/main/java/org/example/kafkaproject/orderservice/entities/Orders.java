package org.example.kafkaproject.orderservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.kafkaproject.orderservice.entities.enums.OrderStatus;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders_table")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderProduct> orderedItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
