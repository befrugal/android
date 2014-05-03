package com.app.closeout.adapter;

import java.util.ArrayList;
import java.util.List;

import com.app.closeout.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SuggestionListAdapter extends BaseAdapter {

	List<String> suggestionArrayList;
	Context context;

	public SuggestionListAdapter(List<String> suggestionArrayList,
			Context context) {
		this.suggestionArrayList = suggestionArrayList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return suggestionArrayList.size();
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
			convertView = inf.inflate(R.layout.suggestion_list_layout, parent,
					false);
		}

		TextView suggestionText = (TextView) convertView
				.findViewById(R.id.textview_suggestion);
		suggestionText.setText(suggestionArrayList.get(position));

		return convertView;
	}

}