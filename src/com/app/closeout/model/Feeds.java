package com.app.closeout.model;

import java.io.Serializable;

public class Feeds implements Serializable {

	private static final long serialVersionUID = 1L;
	private String restaurantName;
	private String username;

	public String getUsername() {
		return username;
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
