package com.example.springdataautomapingobjects.Repository;

import com.example.springdataautomapingobjects.Module.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Override
    Optional<Game> findById(Long aLong);
    void deleteById(Long id);

    @Override
    List<Game> findAll();

    Optional<Game> findByTitle(String title);
}
