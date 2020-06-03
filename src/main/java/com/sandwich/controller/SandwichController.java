package com.sandwich.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sandwich.entity.Sandwich;
import com.sandwich.service.SandwichService;

@RestController
public class SandwichController {

	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

	private SandwichService sandwichService;

	private SandwichController(@Autowired SandwichService sandwichService) {
		this.sandwichService = sandwichService;
	}

	@GetMapping(path = "/getS/all")
	public ResponseEntity<List<Sandwich>> getAllSandwichs() {
		return new ResponseEntity<>(sandwichService.getAllSandwiches(), HttpStatus.OK);
	}

	@GetMapping(path = "/getS/{id}")
	public ResponseEntity<Optional<Sandwich>> getSandwich(@PathVariable("id") Integer id) {
		Optional<Sandwich> existingSandwich = this.sandwichService.getSandwich(id);
		if (existingSandwich.isPresent()) {
			return ResponseEntity.ok(existingSandwich);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "/addS")
	public ResponseEntity<Sandwich> addSandwich(@RequestBody Sandwich sandwich) {
		Sandwich newSandwich = sandwichService.addSandwich(sandwich);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSandwich);
	}

	@PutMapping(path = "/updateS/{id}")
	public ResponseEntity<Optional<Sandwich>> updateSandwich(@PathVariable("id") Integer id,
			@RequestBody Sandwich sandwich) {
		Optional<Sandwich> updatedSandwich = this.sandwichService.updateSandwich(id, sandwich);
		if (updatedSandwich.isPresent()) {
			return ResponseEntity.ok(updatedSandwich);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/deleteS/{id}")
	public ResponseEntity<Integer> deleteSandwich(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(sandwichService.deleteSandwich(id));
	}

}
