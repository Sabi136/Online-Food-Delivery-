package com.tap.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="restaurant_id")
	private int restaurant_id;
	
	@Column(name="restaurant_name")
	private String restaurant_name;
	
	@Column(name="cuisine_type")
	private String cuisine_type;
	
	@Column(name="delivery_time")
	private String delivery_time;
	
	@Column(name="is_active")
	private boolean is_active = true;
	
	@Column(name="ratings")
	private String ratings;
	
	@Column(name="restaurant_img")
	private String restaurant_img;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Menu> menu;

	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getRestaurant_img() {
		return restaurant_img;
	}

	public void setRestaurant_img(String restaurant_img) {
		this.restaurant_img = restaurant_img;
	}

	public Restaurant(int restaurant_id, String restaurant_name, String cuisine_type, String delivery_time,
			boolean is_active, String ratings, String restaurant_img) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.is_active = is_active;
		this.ratings = ratings;
		this.restaurant_img = restaurant_img;
	}

	public Restaurant(String restaurant_name, String cuisine_type, String delivery_time, boolean is_active, String ratings,
			String restaurant_img) {
		super();
		this.restaurant_name = restaurant_name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.is_active = is_active;
		this.ratings = ratings;
		this.restaurant_img = restaurant_img;
	}

	public Restaurant() {
		super();
	}

	public Restaurant(String restaurant_name, String cuisine_type, String delivery_time, String ratings) {
		super();
		this.restaurant_name = restaurant_name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.ratings = ratings;
	}

	public Restaurant(String restaurant_name, String cuisine_type, String delivery_time, String ratings,
			String restaurant_img) {
		super();
		this.restaurant_name = restaurant_name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.ratings = ratings;
		this.restaurant_img = restaurant_img;
	}
}
