package com.app.closeout.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.closeout.R;
import com.app.closeout.model.RestaurantSearchData;

public class SearchResultAdapter extends BaseExpandableListAdapter implements
		OnClickListener {

	Context context;
	ArrayList<RestaurantSearchData> restaurantSearchData;
	private LayoutInflater inf;

	public SearchResultAdapter(Context context,
			ArrayList<RestaurantSearchData> restaurantSearchData) {
		this.context = context;
		this.restaurantSearchData = restaurantSearchData;
		this.inf = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inf.inflate(R.layout.searchresult_c_list_layout,
					parent, false);
		}
		
		Button shareButton = (Button) convertView
				.findViewById(R.id.button_sharedeal);
		Button availButton = (Button) convertView
				.findViewById(R.id.button_availdeal);

		shareButton.setTag(groupPosition);
		availButton.setTag(groupPosition);
		shareButton.setOnClickListener(this);
		availButton.setOnClickListener(this);

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return restaurantSearchData.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return restaurantSearchData.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inf.inflate(R.layout.searchresult_p_list_layout,
					parent, false);
		}

		TextView restaurantName = (TextView) convertView
				.findViewById(R.id.textview_restaurant_name);
		TextView restaurantDetail = (TextView) convertView
				.findViewById(R.id.textview_restaurant_details);
		TextView restaurantDeal = (TextView) convertView
				.findViewById(R.id.textview_restaurant_deal);

		restaurantName.setText(restaurantSearchData.get(groupPosition)
				.getRestaurantName()
				+ " ("
				+ restaurantSearchData.get(groupPosition).getRestaurantRating()
				+ ")");
		restaurantDeal.setText(restaurantSearchData.get(groupPosition)
				.getRestaurantDeal());
		restaurantDetail.setText(restaurantSearchData.get(groupPosition)
				.getRestaurantDetail());

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_availdeal:
			int i = (Integer) v.getTag();
			Toast.makeText(
					context,
					"avail button clicked"
							+ restaurantSearchData.get(i).getRestaurantName(),
					Toast.LENGTH_LONG).show();
			break;
		case R.id.button_sharedeal:
			int i1 = (Integer) v.getTag();
			Toast.makeText(
					context,
					"share button clicked"
							+ restaurantSearchData.get(i1).getRestaurantName(),
					Toast.LENGTH_LONG).show();
			break;
		}
	}

}
