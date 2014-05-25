package com.app.closeout.adapter;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.closeout.R;
import com.app.closeout.RestaurantActivity;
import com.app.closeout.fragments.FragmentTrending;
import com.app.closeout.model.RestaurantSearchData;

public class SearchResultAdapter extends BaseExpandableListAdapter implements
		OnClickListener {

	Context context;
	ArrayList<RestaurantSearchData> restaurantSearchData;
	private LayoutInflater inf;
	ProgressDialog progressDialog;
	FragmentTrending fragmentTrending;
	boolean fromActivity;

	public SearchResultAdapter(Context context,
			ArrayList<RestaurantSearchData> restaurantSearchData,
			FragmentTrending fragmentTrending) {
		this.context = context;
		this.fragmentTrending = fragmentTrending;
		this.restaurantSearchData = restaurantSearchData;
		this.fromActivity = false;
		this.inf = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public SearchResultAdapter(Context context,
			ArrayList<RestaurantSearchData> restaurantSearchData) {
		this.context = context;
		this.restaurantSearchData = restaurantSearchData;
		this.fromActivity = true;
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
		Button moreButton = (Button) convertView
				.findViewById(R.id.button_moredeals);

		shareButton.setTag(groupPosition);
		availButton.setTag(groupPosition);
		moreButton.setTag(groupPosition);
		shareButton.setOnClickListener(this);
		availButton.setOnClickListener(this);
		moreButton.setOnClickListener(this);

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

		restaurantName.setTag(groupPosition);
		restaurantName.setOnClickListener(this);

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
		int p;
		Intent intent;
		switch (v.getId()) {
		case R.id.button_availdeal:
			final int position = (Integer) v.getTag();
			progressDialog = new ProgressDialog(context);
			progressDialog.setCancelable(false);
			progressDialog.setMessage("Getting offer for you..");
			progressDialog.show();
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					progressDialog.dismiss();
					showAlert(position);
				}
			}, 1500);
			break;
		case R.id.button_sharedeal:
			break;
		case R.id.button_moredeals:
			p = (Integer) v.getTag();
			intent = new Intent(context, RestaurantActivity.class);
			intent.putExtra("restName", restaurantSearchData.get(p)
					.getRestaurantName());
			intent.putExtra("restDetail", restaurantSearchData.get(p)
					.getRestaurantDetail());
			context.startActivity(intent);
			break;
		case R.id.textview_restaurant_name:
			p = (Integer) v.getTag();
			intent = new Intent(context, RestaurantActivity.class);
			intent.putExtra("restName", restaurantSearchData.get(p)
					.getRestaurantName());
			intent.putExtra("restDetail", restaurantSearchData.get(p)
					.getRestaurantDetail());
			context.startActivity(intent);
			break;
		}
	}

	public void showAlert(final int position) {
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
		alertBuilder.setCancelable(false).setTitle("Your Deal")
				.setMessage("Use 400 points for 8% discount").create();
		alertBuilder.setPositiveButton("Avail",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						Toast.makeText(context, "You have availed the deal",
								Toast.LENGTH_LONG).show();
						SharedPreferences sharedPreferences = context
								.getSharedPreferences("availedDeals",
										context.MODE_PRIVATE);
						Editor editor = sharedPreferences.edit();
						editor.putString("RestauarntName", restaurantSearchData
								.get(position).getRestaurantName());
						editor.putString("RestaurantDeal", restaurantSearchData
								.get(position).getRestaurantDeal());
						editor.putString("RestaurantDetail",
								restaurantSearchData.get(position)
										.getRestaurantDetail());
						editor.commit();
						if (!fromActivity) {
							fragmentTrending.changeTab();
						}
					}
				});
		alertBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		alertBuilder.show();
	}

}
