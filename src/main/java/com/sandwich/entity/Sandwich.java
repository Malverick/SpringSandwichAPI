package com.sandwich.entity;

import javax.persistence.*;

@Entity
@Table(name = "sandwich")
public class Sandwich {
	
	public Sandwich() {}
	
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "sand_name", nullable = false, length = 40)
	private String sand_name;

	@Column(name = "sand_content", nullable = false, length = 200)
	private String sand_content;

	public Sandwich(String sand_name, String sand_content) {
		this.sand_name = sand_name;
		this.sand_content = sand_content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSand_name() {
		return sand_name;
	}

	public void setSand_name(String sand_name) {
		this.sand_name = sand_name;
	}

	public String getSand_content() {
		return sand_content;
	}

	public void setSand_content(String sand_content) {
		this.sand_content = sand_content;
	}

}
