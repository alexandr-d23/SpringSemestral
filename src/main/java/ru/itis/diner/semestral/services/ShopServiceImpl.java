package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.diner.semestral.dto.ProductDto;
import ru.itis.diner.semestral.model.BoostTypes;
import ru.itis.diner.semestral.model.Product;
import ru.itis.diner.semestral.repositories.ProductRepository;

import java.util.List;

public class ShopServiceImpl implements ShopService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .cost(productDto.getCost())
                .type(BoostTypes.valueOf(productDto.getType()))
                .value(productDto.getValue())
                .description(productDto.getDescription())
                .build();
        repository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        Product product = Product.builder()
                .cost(productDto.getCost())
                .type(BoostTypes.valueOf(productDto.getType()))
                .value(productDto.getValue())
                .description(productDto.getDescription())
                .id(id)
                .build();
        repository.save(product);
    }
}
