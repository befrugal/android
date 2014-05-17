package com.app.closeout;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ExpandableListView;

import com.app.closeout.adapter.SearchResultAdapter;
import com.app.closeout.model.RestaurantSearchData;

public class SearchResultActivity extends Activity {

	Context context;
	SearchResultAdapter searchResultAdapter;
	ExpandableListView searchResultList;
	ArrayList<RestaurantSearchData> restaurantSearchData;
	int width;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);

		context = this;
		ArrayList<String> restName = new ArrayList<String>();
		restName.add("Toit");
		restName.add("ABC");
		restName.add("Barbeque Nation");
		restName.add("Hunan");
		restName.add("Punjab Grill");
		restName.add("Copper Chimney");
		restName.add("Little Italy");
		restName.add("California Pizza Kitchen");
		restName.add("Costa Coffee");
		restName.add("Hard Rock Cafe");
		
		ArrayList<String> rating = new ArrayList<String>();
		rating.add("3.9");
		rating.add("3.7");
		rating.add("3.6");
		rating.add("4.0");
		rating.add("3.4");
		rating.add("3.9");
		rating.add("3.3");
		rating.add("3.4");
		rating.add("3.8");
		rating.add("4.0");

		ArrayList<String> detail = new ArrayList<String>();
		detail.add("100 Feet Road, Indiranagar");
		detail.add("Magrath Road, Near MG Road, Bangalore");
		detail.add("100 Feet Road, 2nd Stage, HAL, Indiranagar");
		detail.add("Opposite California Pizza Kitchen, 5th Block, Koramangala");
		detail.add("Opposite Forum Mall, 7th Block, Koramangala");
		detail.add("100 Feet Road, HAL 2nd Stage, Indiranagar");
		detail.add("100 Feet Road, HAL 2nd Stage, Indiranagar");
		detail.add("Jyothi Nivas College Road, 5th Block, Koramangala");
		detail.add("80 Feet Road, 4th Block, Koramangala");
		detail.add("40, Off MG Road, St. Marks Road");
		
		ArrayList<String> deal = new ArrayList<String>();
		deal.add("10% for 500 points");
		deal.add("10% for 400 points");
		deal.add("8% for 400 points");
		deal.add("10% for 400 points");
		deal.add("10% for 600 points");
		deal.add("12% for 400 points");
		deal.add("10% for 500 points");
		deal.add("10% for 400 points");
		deal.add("12 for 400 points");
		deal.add("10% for 500 points");
		
		restaurantSearchData = new ArrayList<RestaurantSearchData>();
		for (int i = 0; i < 10; i++) {
			RestaurantSearchData restaurantSearchDataObj = new RestaurantSearchData();
			restaurantSearchDataObj
					.setRestaurantDetail(detail.get(i));
			restaurantSearchDataObj.setRestaurantRating(rating.get(i));
			restaurantSearchDataObj
					.setRestaurantName(restName.get(i));
			restaurantSearchDataObj.setRestaurantDeal(deal.get(i));
			restaurantSearchData.add(restaurantSearchDataObj);
		}
		searchResultAdapter = new SearchResultAdapter(context,
				restaurantSearchData);
		searchResultList = (ExpandableListView) findViewById(R.id.listview_searchresults);

		searchResultList.setAdapter(searchResultAdapter);

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		width = metrics.widthPixels;
		
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
			searchResultList.setIndicatorBounds(width-100, width);
		} else {
			searchResultList.setIndicatorBoundsRelative(width-150, width);
		}

	}
}
