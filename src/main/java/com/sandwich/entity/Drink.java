package com.sandwich.entity;

import javax.persistence.*;

@Entity
public class Drink {

	public Drink() {
	}

	public Drink(String drink_name, String drink_type) {
		this.drink_name = drink_name;
		this.drink_type = drink_type;
	}

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String drink_name;

	@Column
	private String drink_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrink_name() {
		return drink_name;
	}

	public void setDrink_name(String drink_name) {
		this.drink_name = drink_name;
	}

	public String getDrink_type() {
		return drink_type;
	}

	public void setDrink_type(String drink_type) {
		this.drink_type = drink_type;
	}

}
