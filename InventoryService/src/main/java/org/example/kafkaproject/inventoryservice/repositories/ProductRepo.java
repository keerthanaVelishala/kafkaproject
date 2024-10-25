package org.example.kafkaproject.inventoryservice.repositories;

import org.example.kafkaproject.inventoryservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
