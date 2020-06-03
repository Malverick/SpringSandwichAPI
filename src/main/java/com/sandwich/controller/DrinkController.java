package com.sandwich.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.entity.Drink;
import com.sandwich.service.DrinkService;


@RestController
public class DrinkController {

	private DrinkService drinkService;

	private DrinkController(@Autowired DrinkService drinkService) {
		this.drinkService = drinkService;
	}

	@GetMapping(path = "/getD/all")
	public ResponseEntity<List<Drink>> getAllDrinks() {
		return new ResponseEntity<>(drinkService.getAllDrinks(), HttpStatus.OK);
	}

	@GetMapping(path = "/getD/{id}")
	public ResponseEntity<Optional<Drink>> getDrink(@PathVariable("id") Integer id) {
		Optional<Drink> existingDrink = drinkService.getDrink(id);
		if (existingDrink.isPresent()) {
			return ResponseEntity.ok(existingDrink);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "/addD")
	public ResponseEntity<Drink> addDrink(@RequestBody Drink drink) {
		Drink newDrink = drinkService.addDrink(drink);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDrink);
	}

	@PutMapping(path = "/updateD/{id}")
	public ResponseEntity<Optional<Drink>> updateDrink(@PathVariable("id") Integer id, @RequestBody Drink drink) {
		Optional<Drink> updatedDrink = this.drinkService.updateDrink(id, drink);
		if (updatedDrink.isPresent()) {
			return ResponseEntity.ok(updatedDrink);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path = "/deleteD/{id}")
	public ResponseEntity<Integer> deleteDrink(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(drinkService.deleteDrink(id));
	}

}
