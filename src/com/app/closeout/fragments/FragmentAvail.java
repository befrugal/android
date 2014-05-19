package com.app.closeout.fragments;

import java.util.ArrayList;

import com.app.closeout.R;
import com.app.closeout.adapter.AvailListAdapter;
import com.app.closeout.adapter.FeedListAdapter;
import com.app.closeout.model.RestaurantSearchData;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class FragmentAvail extends Fragment {

	Context context;
	SharedPreferences sharedPreferences;

	public FragmentAvail() {
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
		View layout_avail = inflater.inflate(R.layout.fragment_avail,
				container, false);

		ListView availList = (ListView) layout_avail
				.findViewById(R.id.list_avail);

		ArrayList<RestaurantSearchData> restaurantSearchData = new ArrayList<RestaurantSearchData>();

		RestaurantSearchData restaurantSearchDataObj = new RestaurantSearchData();

		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"availedDeals", context.MODE_PRIVATE);
		restaurantSearchDataObj.setRestaurantDetail(sharedPreferences
				.getString("RestaurantDetail", "").toString());
		restaurantSearchDataObj.setRestaurantName(sharedPreferences.getString(
				"RestauarntName", "").toString());
		restaurantSearchDataObj.setRestaurantDeal(sharedPreferences.getString(
				"RestaurantDeal", "").toString());
		restaurantSearchData.add(restaurantSearchDataObj);

		AvailListAdapter availListAdapter = new AvailListAdapter(
				restaurantSearchData, context);

		availList.setAdapter(availListAdapter);

		return layout_avail;
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
