package org.example.kafkaproject.inventoryservice.services;


import lombok.RequiredArgsConstructor;
import org.example.kafkaproject.inventoryservice.entities.ProductEntity;
import org.example.kafkaproject.inventoryservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public ProductEntity addProduct(ProductEntity product){
        return productRepo.save(product);
    }
}
