package ru.itis.diner.semestral.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.diner.semestral.dto.ProductDto;
import ru.itis.diner.semestral.dto.ProductRest;
import ru.itis.diner.semestral.model.Product;
import ru.itis.diner.semestral.services.ShopService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductRestController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductRest>> getAllProducts() {
        return ResponseEntity.ok(shopService
                .getProducts()
                .stream()
                .map(product -> ProductRest.builder()
                        .id(product.getId())
                        .cost(product.getCost())
                        .description(product.getDescription())
                        .type(product.getType())
                        .value(product.getValue())
                        .build())
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product) {
        shopService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{product-id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("product-id") Long productId, @RequestBody ProductDto product) {
        shopService.updateProduct(productId, product);
        return ResponseEntity.ok(product);
    }


}
