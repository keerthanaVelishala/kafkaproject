package org.example.kafkaproject.inventoryservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproject.inventoryservice.dtos.ProductDTO;
import org.example.kafkaproject.inventoryservice.entities.ProductEntity;
import org.example.kafkaproject.inventoryservice.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class inventroyController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping("/addStock")
    public ResponseEntity<ProductDTO> addProductToRepo(@RequestBody ProductDTO product){
        ProductEntity productDAO = modelMapper.map(product,ProductEntity.class);
        ProductEntity savedEntity = productService.addProduct(productDAO);
        ProductDTO savedProduct = modelMapper.map(savedEntity,ProductDTO.class);
        return new ResponseEntity<>(savedProduct, HttpStatusCode.valueOf(201));
    }



}
