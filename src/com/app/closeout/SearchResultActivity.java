package com.app.closeout;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
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
		restaurantSearchData = new ArrayList<RestaurantSearchData>();
		for (int i = 0; i < 10; i++) {
			RestaurantSearchData restaurantSearchDataObj = new RestaurantSearchData();
			restaurantSearchDataObj
					.setRestaurantDetail("This is the restaurant no" + (i + 1));
			restaurantSearchDataObj.setRestaurantRating(String
					.valueOf((i + 1) * 0.5));
			restaurantSearchDataObj.setRestaurantName("Restaurant no" + (i + 1));
			restaurantSearchDataObj.setRestaurantDeal("10% off for 500 points");
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
			searchResultList.setIndicatorBounds(width-50, width);
		} else {
			searchResultList.setIndicatorBoundsRelative(width-50, width);
		}

	}
}
