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

public class FragmentFeed extends Fragment {
	
	Context context;
	ListView feedList;
	ArrayList<Feeds> feedData;
	FeedListAdapter feedListAdapter;
	
	public FragmentFeed(){
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
		View layout_feed = inflater.inflate(R.layout.fragment_feed, container, false);
		
		ArrayList<String> name = new ArrayList<String>();
		name.add("Siddhant Jain");
		name.add("Ashish Singhal");
		name.add("Rohit Gupta");
		name.add("Govind Soni");
		name.add("Brajesh Upadhyay");
		
		ArrayList<String> restName = new ArrayList<String>();
		restName.add("Toit");
		restName.add("Dominos");
		restName.add("Hunan");
		restName.add("California Pizza Kitchen");
		restName.add("Hard Rock Cafe");
		
		ArrayList<String> discount = new ArrayList<String>();
		discount.add("12");
		discount.add("20");
		discount.add("8");
		discount.add("15");
		discount.add("10");
		
		feedData = new ArrayList<Feeds>();
		for (int i = 0; i < 5; i++) {
			Feeds feedsObj = new Feeds();
			feedsObj.setRestaurantName(restName.get(i));
			feedsObj.setUsername(name.get(i));
			feedsObj.setDiscount(discount.get(i));
			feedData.add(feedsObj);
		}
		
		feedList = (ListView) layout_feed.findViewById(R.id.listview_feeds);
		
		feedListAdapter = new FeedListAdapter(feedData, context);
		
		feedList.setAdapter(feedListAdapter);
		
		return layout_feed;
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
