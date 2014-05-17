package com.app.closeout.fragments;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.closeout.R;
import com.app.closeout.adapter.FeedListAdapter;
import com.app.closeout.model.Feeds;

public class SlidingMenuFragment extends Fragment {
	
	Context context;
	ListView feedList;
	ArrayList<Feeds> feedData;
	FeedListAdapter feedListAdapter;
	
	public SlidingMenuFragment(){
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
		View layout_sliding_menu = inflater.inflate(R.layout.fragment_sliding_menu, container, false);
		
		feedData = new ArrayList<Feeds>();
		for (int i = 0; i < 10; i++) {
			Feeds feedsObj = new Feeds();
			feedsObj.setRestaurantName("Restaurant no" + (i + 1));
			feedsObj.setUsername("Username " + (i+1));
			feedData.add(feedsObj);
		}
		
		/*feedList = (ListView) layout_feed.findViewById(R.id.listview_feeds);
		
		feedListAdapter = new FeedListAdapter(feedData, context);
		
		feedList.setAdapter(feedListAdapter);*/
		
		return layout_sliding_menu;
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
