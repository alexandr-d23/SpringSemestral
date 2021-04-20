package ru.itis.diner.semestral.services;

import ru.itis.diner.semestral.model.Product;

import java.util.List;

public interface ProfileService {
    List<Product> getProductsByUserId(Long userId);
}
