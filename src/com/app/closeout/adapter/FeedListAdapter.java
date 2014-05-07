package com.app.closeout.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.closeout.R;
import com.app.closeout.model.Feeds;

public class FeedListAdapter extends BaseAdapter {

	List<Feeds> feedArrayList;
	Context context;

	public FeedListAdapter(List<Feeds> feedArrayList,
			Context context) {
		this.feedArrayList = feedArrayList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return feedArrayList.size();
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
			convertView = inf.inflate(R.layout.feed_list_layout, parent,
					false);
		}

		TextView usernameText = (TextView) convertView
				.findViewById(R.id.textview_feedname);
		usernameText.setText(feedArrayList.get(position).getUsername());
		
		TextView feedDetailText = (TextView) convertView
				.findViewById(R.id.textview_feeddetail);
		feedDetailText.setText("Visited " + feedArrayList.get(position).getRestaurantName()
				+ " Got a good deal");

		return convertView;
	}

}