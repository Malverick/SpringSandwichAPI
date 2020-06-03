package com.sandwich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandwich.entity.Drink;
import com.sandwich.service.DrinkService;

@RestController
public class DrinkController {

	private DrinkService drinkService;
	
	private DrinkController(@Autowired DrinkService drinkService) {
		this.drinkService = drinkService;		
	}
	
	@GetMapping(path="/getD/all")
	public ResponseEntity<List<Drink>> getAll(){
		
	}
	
}
