package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.model.Product;
import ru.itis.diner.semestral.repositories.ProductRepository;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.getProductsByUserId(userId);
    }
}
