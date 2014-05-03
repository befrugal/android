package com.app.closeout.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.closeout.R;
import com.app.closeout.SearchActivity;

public class FragmentSearch extends Fragment implements OnClickListener {

	Context context;
	Button searchButton;
	Button qrScanButton;

	public FragmentSearch() {
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
		View layout_search = inflater.inflate(R.layout.fragment_search,
				container, false);

		searchButton = (Button) layout_search.findViewById(R.id.button_search);
		qrScanButton = (Button) layout_search.findViewById(R.id.button_qrscan);

		searchButton.setOnClickListener(this);
		qrScanButton.setOnClickListener(this);

		return layout_search;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_search:
			Intent intent = new Intent(context, SearchActivity.class);
			startActivity(intent);
			break;
		case R.id.button_qrscan:
			//code to call qr scanner will go here
			break;
		}
	}
	
}
