package ru.itis.diner.semestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.diner.semestral.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM (SELECT p.product_id FROM product_users as p " +
                    "where p.account_id = :userId) as p " +
                    "INNER JOIN product ON p.product_id = product.id"
    )
    List<Product> getProductsByUserId(Long userId);

}
