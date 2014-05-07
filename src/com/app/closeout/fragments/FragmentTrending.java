package com.app.closeout.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.app.closeout.R;
import com.app.closeout.adapter.SearchResultAdapter;
import com.app.closeout.model.RestaurantSearchData;

public class FragmentTrending extends Fragment {

	Context context;

	SearchResultAdapter searchResultAdapter;
	ExpandableListView searchResultList;
	ArrayList<RestaurantSearchData> restaurantSearchData;
	int width;

	public FragmentTrending() {
	}

	@Override
	public void onAttach(Activity activity) {
		context = activity.getApplicationContext();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layout_nearby = inflater.inflate(R.layout.fragment_trending,
				container, false);

		restaurantSearchData = new ArrayList<RestaurantSearchData>();
		for (int i = 0; i < 10; i++) {
			RestaurantSearchData restaurantSearchDataObj = new RestaurantSearchData();
			restaurantSearchDataObj
					.setRestaurantDetail("This is the restaurant no" + (i + 1));
			restaurantSearchDataObj.setRestaurantRating(String
					.valueOf((i + 1) * 0.5));
			restaurantSearchDataObj
					.setRestaurantName("Restaurant no" + (i + 1));
			restaurantSearchDataObj.setRestaurantDeal("10% off for 500 points");
			restaurantSearchData.add(restaurantSearchDataObj);
		}
		searchResultAdapter = new SearchResultAdapter(context,
				restaurantSearchData);
		searchResultList = (ExpandableListView) layout_nearby
				.findViewById(R.id.listview_trendingresults);

		searchResultList.setAdapter(searchResultAdapter);

		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

		width = metrics.widthPixels;

		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
			searchResultList.setIndicatorBounds(width - 100, width);
		} else {
			searchResultList.setIndicatorBoundsRelative(width - 100, width);
		}

		return layout_nearby;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

}
