package com.app.closeout;

import java.util.ArrayList;

import com.app.closeout.adapter.RestDealListAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class RestaurantActivity extends Activity {

	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resturant);
		
		context = this;
		
		String restName = getIntent().getExtras().getString("restName");
		String restDetail = getIntent().getExtras().getString("restDetail");
		
		TextView restNameText = (TextView) findViewById(R.id.textview_restpage_name);
		TextView restDetailText = (TextView) findViewById(R.id.textview_restpage_detail);
		
		
		restNameText.setText(restName);
		restDetailText.setText(restDetail);
		
		ArrayList<String> deal = new ArrayList<String>();
		deal.add("10% for 400 points on weekdays");
		deal.add("8% for 400 points");
		deal.add("10% for 500 points on weekends");
		deal.add("10% for 600 points for lunch");
		deal.add("12% for 700 points");
		deal.add("15 for 1000 points");
		
		ListView dealList = (ListView) findViewById(R.id.list_restdeals);
		RestDealListAdapter restDealListAdapter = new RestDealListAdapter(deal, context);
		
		dealList.setAdapter(restDealListAdapter);
		
	}

}
