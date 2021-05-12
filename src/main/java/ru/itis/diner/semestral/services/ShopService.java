package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.dto.ProductDto;
import ru.itis.diner.semestral.dto.ProductForm;
import ru.itis.diner.semestral.model.Product;
import ru.itis.diner.semestral.util.Answer;

import java.util.List;

public interface ShopService {
    List<Product> getProducts();
    void addProduct(ProductDto productDto);
    void updateProduct(Long id, ProductDto productDto);
    Answer buyProduct(Long userId, ProductForm form);
    Long getUserScoreById(Long id);
}
