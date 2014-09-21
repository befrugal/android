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

import com.app.closeout.MainActivity;
import com.app.closeout.R;
import com.app.closeout.adapter.SearchResultAdapter;
import com.app.closeout.model.RestaurantSearchData;

public class FragmentTrending extends Fragment {

	Context context;

	SearchResultAdapter searchResultAdapter;
	ExpandableListView searchResultList;
	ArrayList<RestaurantSearchData> restaurantSearchData;
	int width;

	public FragmentTrending(Context context) {
		this.context = context;
	}

	@Override
	public void onAttach(Activity activity) {
		//context = activity.getApplicationContext();
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
		deal.add("Get one complimentary drink for 150 points");
		deal.add("Get a starter free for 100 points");
		deal.add("Rs. 250 off for 120 points");
		deal.add("Get a dessert free for 75 points");
		deal.add("Rs. 400 off on your bill for 130 points");
		deal.add("Get a starter free for 80 points");
		deal.add("Get a free pickup and drop for 400 points");
		deal.add("Get a free pizza for 250 points");
		deal.add("Get a free coffee for 50 points");
		deal.add("Get free beer for 125 points");
		
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
				restaurantSearchData, FragmentTrending.this);
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
	
	public void changeTab(){
		MainActivity mainActivity = new MainActivity();
		mainActivity.moveToAvail();
	}
	
}
