package ru.itis.diner.semestral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.dto.ProductDto;
import ru.itis.diner.semestral.dto.ProductForm;
import ru.itis.diner.semestral.model.*;
import ru.itis.diner.semestral.util.Answer;
import ru.itis.diner.semestral.repositories.ActionRepository;
import ru.itis.diner.semestral.repositories.ProductRepository;
import ru.itis.diner.semestral.repositories.UserRepository;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .cost(productDto.getCost())
                .type(BoostTypes.valueOf(productDto.getType()))
                .value(productDto.getValue())
                .description(productDto.getDescription())
                .build();
        productRepository.save(product);
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
        productRepository.save(product);
    }

    @Override
    public Answer buyProduct(Long userId, ProductForm form) {
        User user = userRepository.findById(userId).get();
        Product product = productRepository.findById(form.getId()).get();
        if (user.getScore() < product.getCost()) {
            return Answer.builder()
                    .isSuccessful(false)
                    .description("Недостаточно средств")
                    .build();
        }
        user.getProducts().add(product);
        user.setScore(user.getScore()- product.getCost());
        ActionManager.saveAction(user, AchievementTypes.BUY_ITEM, 1L, actionRepository);
        ActionManager.saveAction(user,AchievementTypes.SPEND_MONEY, product.getCost(), actionRepository);
        userRepository.save(user);
        return Answer.builder()
                .isSuccessful(true)
                .build();
    }



    @Override
    public Long getUserScoreById(Long id) {
        return userRepository.getUserScoreById(id);
    }

}
