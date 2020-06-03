package com.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandwich.entity.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer>{

}
