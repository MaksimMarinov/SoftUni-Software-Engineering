package com.example.exr_json.repo;

import com.example.exr_json.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT count(p) FROM Product p WHERE p.seller.id = u.id) > 0" +
            " ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName();

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT count(p) FROM Product p WHERE u.id = p.seller.id) > 0 " +
            "ORDER BY u.soldProducts.size DESC")
    List<User> findAllUsersWithMoreThanOneSoldProductOrderByNumberOfProductsSold();
}
