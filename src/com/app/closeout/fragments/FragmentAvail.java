package com.app.closeout.fragments;

import com.app.closeout.R;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"availedDeals", context.MODE_PRIVATE);
		System.out.println("!!! "
				+ sharedPreferences.getString("RestauarntName", ""));
		System.out.println("!!! "
				+ sharedPreferences.getString("RestaurantDeal", ""));
		TextView tv = (TextView) layout_avail.findViewById(R.id.avail_txt);
		tv.setText(sharedPreferences.getString("RestauarntName", "").toString()
				+ sharedPreferences.getString("RestaurantDeal", "").toString());
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
