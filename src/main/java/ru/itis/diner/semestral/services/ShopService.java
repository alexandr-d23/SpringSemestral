package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.dto.ProductDto;
import ru.itis.diner.semestral.model.Product;

import java.util.List;

public interface ShopService {
    List<Product> getProducts();
    void addProduct(ProductDto productDto);
    void updateProduct(Long id, ProductDto productDto);
}
