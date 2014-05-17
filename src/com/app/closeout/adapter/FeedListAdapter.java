package com.app.closeout.adapter;

import java.util.List;
import java.util.Random;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.closeout.R;
import com.app.closeout.model.Feeds;

public class FeedListAdapter extends BaseAdapter {

	List<Feeds> feedArrayList;
	Context context;

	public FeedListAdapter(List<Feeds> feedArrayList, Context context) {
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
			convertView = inf.inflate(R.layout.feed_list_layout, parent, false);
		}

		TextView usernameText = (TextView) convertView
				.findViewById(R.id.textview_feedname);
		usernameText.setText(feedArrayList.get(position).getUsername());

		TextView restNameText = (TextView) convertView
				.findViewById(R.id.textview_feedrestname);
		restNameText.setText("Went to "
				+ feedArrayList.get(position).getRestaurantName());

		TextView timeText = (TextView) convertView
				.findViewById(R.id.textview_feedtime);
		Random rand = new Random();
		timeText.setText("(" + rand.nextInt(10) + " days ago)");

		TextView feedDetailText = (TextView) convertView
				.findViewById(R.id.textview_feeddetail);
		feedDetailText.setText("Got "
				+ feedArrayList.get(position).getDiscount() + "% discount");

		ImageView profileImageView = (ImageView) convertView
				.findViewById(R.id.image_feed);
		if (feedArrayList.get(position).getUsername().equals("Siddhant Jain")) {
			profileImageView.setImageResource(R.drawable.profile_siddhant);
		} else if (feedArrayList.get(position).getUsername()
				.equals("Ashish Singhal")) {
			profileImageView.setImageResource(R.drawable.profile_ashish);
		} else if (feedArrayList.get(position).getUsername()
				.equals("Rohit Gupta")) {
			profileImageView.setImageResource(R.drawable.profile_rohit);
		} else if (feedArrayList.get(position).getUsername()
				.equals("Govind Soni")) {
			profileImageView.setImageResource(R.drawable.profile_govind);
		} else if (feedArrayList.get(position).getUsername()
				.equals("Brajesh Upadhyay")) {
			profileImageView.setImageResource(R.drawable.profile_brajesh);
		}

		return convertView;
	}

}