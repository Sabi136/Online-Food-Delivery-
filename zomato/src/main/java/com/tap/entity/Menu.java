package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="menu")
public class Menu 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	private int menu_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	
	@Column(name="item_name")
	private String item_name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="is_available")
	private boolean is_available = true;
	
	@Column(name="menu_img")
	private String menu_img;

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	public String getMenu_img() {
		return menu_img;
	}

	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}

	public Menu(int menu_id, Restaurant restaurant, String item_name, String description, int price,
			boolean is_available, String menu_img) {
		super();
		this.menu_id = menu_id;
		this.restaurant = restaurant;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
		this.menu_img = menu_img;
	}

	public Menu() {
		super();
	}

	public Menu(Restaurant restaurant, String item_name, String description, int price, boolean is_available,
			String menu_img) {
		super();
		this.restaurant = restaurant;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
		this.menu_img = menu_img;
	}

	public Menu(String item_name, String description, int price, boolean is_available, String menu_img) {
		super();
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.is_available = is_available;
		this.menu_img = menu_img;
	}
}
