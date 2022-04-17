package com.example.advquerying.repository;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findIngredientByNameStartingWith(String start);
    List<Ingredient> findIngredientByNameIn(Collection<String> names);
    @Query("DELETE FROM Ingredient i where i.name = :name")
    @Modifying
    @Transactional
    void deleteAllByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price*1.1")
    @Modifying
    @Transactional
    void upgradeIngredientsByPrice();

    @Query("UPDATE Ingredient i SET i.price = i.price * :modifier WHERE i.name IN (:names)")
    @Modifying
    @Transactional
    void upgradeIngredientsByName(BigDecimal modifier, Collection<String> names);
}
