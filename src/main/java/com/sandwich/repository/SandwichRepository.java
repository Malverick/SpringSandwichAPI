package com.sandwich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandwich.entity.Sandwich;

public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {

}
