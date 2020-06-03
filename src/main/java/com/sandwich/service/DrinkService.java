package com.sandwich.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.entity.Drink;
import com.sandwich.repository.DrinkRepository;

@Service
public class DrinkService {

	private DrinkRepository drinkRepository;

	public DrinkService(@Autowired DrinkRepository drinkRepository) {
		this.drinkRepository = drinkRepository;
	}

	public List<Drink> getAllDrinks() {
		return (List<Drink>) drinkRepository.findAll();
	}

	public Optional<Drink> getDrink(int id) {
		return (Optional<Drink>) drinkRepository.findById(id);
	}

	public Drink addDrink(Drink drink) {
		drinkRepository.save(drink);
		return drink;
	}

	public Integer deleteDrink(int id) {
		drinkRepository.deleteById(id);
		return id;
	}

	public Optional<Drink> updateDrink(int id, Drink drink) {
		return drinkRepository.findById(id).map(updatedDrink -> {
			updatedDrink.setDrink_name(drink.getDrink_name());
			updatedDrink.setDrink_type(drink.getDrink_type());
			return drinkRepository.save(updatedDrink);
		});
	}

}
