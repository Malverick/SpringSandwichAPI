package com.sandwich.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandwich.repository.SandwichRepository;

@Component
public class DataLoader {

	private SandwichRepository sandwichRepository;

	@Autowired
	public DataLoader(SandwichRepository sandwichRepository) {
		this.sandwichRepository = sandwichRepository;
		LoadSandwiches();
	}

	private void LoadSandwiches() {
		sandwichRepository.save(new Sandwich("Ham and Cheese", "Ham, Cheese, Butter, Brown Bread"));
		sandwichRepository.save(new Sandwich("BLT", "Bacon, Lettuce, Tomatoe, Butter, Seed Bread"));
		sandwichRepository.save(new Sandwich("Sausage and Egg", "Sausage, Egg, Butter, White Bread"));
	}
}
