package com.app.closeout.adapter;

import java.util.ArrayList;

import com.app.closeout.R;
import com.app.closeout.model.RestaurantSearchData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AvailListAdapter extends BaseAdapter {

	ArrayList<RestaurantSearchData> restaurantSearchData;
	Context context;
	
	public AvailListAdapter(ArrayList<RestaurantSearchData> restaurantSearchData, Context context){
		this.restaurantSearchData = restaurantSearchData;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return restaurantSearchData.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inf.inflate(R.layout.avail_list_layout, parent, false);
		}
		
		TextView restName = (TextView) convertView.findViewById(R.id.textview_restaurant_name);
		TextView restDeal = (TextView) convertView.findViewById(R.id.textview_restaurant_deal);
		TextView restDetail = (TextView) convertView.findViewById(R.id.textview_restaurant_details);
		
		restName.setText(restaurantSearchData.get(position).getRestaurantName());
		restDeal.setText(restaurantSearchData.get(position).getRestaurantDeal());
		restDetail.setText(restaurantSearchData.get(position).getRestaurantDetail());
				
		return convertView;
	}

}
