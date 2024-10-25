package org.example.kafkaproject.orderservice.repositories;

import org.example.kafkaproject.orderservice.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepo extends JpaRepository<Orders,Long> {
}
