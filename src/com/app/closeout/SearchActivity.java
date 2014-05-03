package com.app.closeout;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.app.closeout.adapter.SuggestionListAdapter;

public class SearchActivity extends Activity implements OnClickListener {

	Context context;
	
	EditText search;
	ListView suggestionsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;
		setContentView(R.layout.activity_search);
		
		search = (EditText) findViewById(R.id.edittext_search);
		suggestionsList = (ListView) findViewById(R.id.listview_suggestions);
		
		String[] suggestionArray = getResources().getStringArray(R.array.suggestion_list);
		List<String> suggestionArrayList = Arrays.asList(suggestionArray);
		
		SuggestionListAdapter suggestionAdapter = new SuggestionListAdapter(suggestionArrayList,context);
		suggestionsList.setAdapter(suggestionAdapter);
		
		
		
	}

	@Override
	public void onClick(View v) {
	}

}