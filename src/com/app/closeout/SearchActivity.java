package com.app.closeout;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.app.closeout.adapter.SuggestionListAdapter;

public class SearchActivity extends Activity implements OnClickListener {

	Context context;

	EditText search;
	ListView suggestionsList;
	TextView listHeaderTextview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;
		setContentView(R.layout.activity_search);

		search = (EditText) findViewById(R.id.edittext_search);
		suggestionsList = (ListView) findViewById(R.id.listview_suggestions);
		listHeaderTextview = (TextView) findViewById(R.id.textview_listheader);

		String[] suggestionArray = getResources().getStringArray(
				R.array.suggestion_list);
		List<String> suggestionArrayList = Arrays.asList(suggestionArray);

		SuggestionListAdapter suggestionAdapter = new SuggestionListAdapter(
				suggestionArrayList, context);
		suggestionsList.setAdapter(suggestionAdapter);

		search.addTextChangedListener(new CustomTextWatcher(search));

		suggestionsList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(context, SearchResultActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public void onClick(View v) {
	}

	private class CustomTextWatcher implements TextWatcher {
		private EditText mEditText;

		public CustomTextWatcher(EditText e) {
			mEditText = e;
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}

		public void afterTextChanged(Editable s) {
			switch (mEditText.getId()) {
			case R.id.edittext_search:
				if (mEditText.getText().toString() == null
						|| mEditText.getText().toString().equals("")) {
					suggestionsList.setVisibility(View.VISIBLE);
					listHeaderTextview.setText(getResources().getString(R.string.popular_searches));
				} else{
					suggestionsList.setVisibility(View.GONE);
					listHeaderTextview.setText("you searching for " + mEditText.getText().toString());
				}
				break;

			}
		}
	}

}