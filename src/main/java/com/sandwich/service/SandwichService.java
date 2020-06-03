package com.sandwich.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwich.entity.Sandwich;
import com.sandwich.repository.SandwichRepository;

@Service
public class SandwichService {

	private SandwichRepository sandwichRepository;

	public SandwichService(@Autowired SandwichRepository sandwichRepository) {
		this.sandwichRepository = sandwichRepository;
	}

	public List<Sandwich> getAllSandwiches() {
		return (List<Sandwich>) sandwichRepository.findAll();
	}

	public Optional<Sandwich> getSandwich(int id) {
		return (Optional<Sandwich>) sandwichRepository.findById(id);
	}

	public Sandwich addSandwich(Sandwich sandwich) {
		sandwichRepository.save(sandwich);
		return sandwich;
	}

	public Integer deleteSandwich(Integer id) {
		sandwichRepository.deleteById(id);
		return id;
	}

	public Optional<Sandwich> updateSandwich(Integer id, Sandwich sandwich) {
		return sandwichRepository.findById(id).map(updatedSandwich -> {
			updatedSandwich.setSand_name(sandwich.getSand_name());
			updatedSandwich.setSand_content(sandwich.getSand_content());
			return sandwichRepository.save(updatedSandwich);
		});
	}

}
