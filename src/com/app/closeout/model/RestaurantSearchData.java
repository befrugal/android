package com.app.closeout.model;

import java.io.Serializable;

public class RestaurantSearchData implements Serializable {

	private static final long serialVersionUID = 1L;
	private String restaurantName;
	private String restaurantRating;
	private String restaurantDetail;
	private String restaurantDeal;

	public String getRestaurantDeal() {
		return restaurantDeal;
	}

	public void setRestaurantDeal(String restaurantDeal) {
		this.restaurantDeal = restaurantDeal;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(String restaurantRating) {
		this.restaurantRating = restaurantRating;
	}

	public String getRestaurantDetail() {
		return restaurantDetail;
	}

	public void setRestaurantDetail(String restaurantDetail) {
		this.restaurantDetail = restaurantDetail;
	}

}
