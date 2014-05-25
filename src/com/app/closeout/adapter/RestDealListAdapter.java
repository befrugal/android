package com.app.closeout.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.closeout.R;

public class RestDealListAdapter extends BaseAdapter {

	ArrayList<String> restaurantDealData;
	Context context;

	public RestDealListAdapter(ArrayList<String> restaurantDealData,
			Context context) {
		this.restaurantDealData = restaurantDealData;
		this.context = context;
	}

	@Override
	public int getCount() {
		return restaurantDealData.size();
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
			convertView = inf.inflate(R.layout.list_restpage, parent, false);
		}

		TextView deal = (TextView) convertView
				.findViewById(R.id.textview_restlistdeal);

		deal.setText(restaurantDealData.get(position));

		return convertView;
	}

}
