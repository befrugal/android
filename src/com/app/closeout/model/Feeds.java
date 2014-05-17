package com.app.closeout.model;

import java.io.Serializable;

public class Feeds implements Serializable {

	private static final long serialVersionUID = 1L;
	private String restaurantName;
	private String username;
	private String discount;

	public String getUsername() {
		return username;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

}
