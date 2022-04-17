package com.example.exr_json.repo;

import com.example.exr_json.model.entity.Product;
import com.example.exr_json.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lower, BigDecimal upper);


}
