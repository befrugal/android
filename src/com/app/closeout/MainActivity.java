package com.app.closeout;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Watson.OnOptionsItemSelectedListener;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.closeout.adapter.SectionsPagerAdapter;
import com.app.closeout.fragments.SlidingMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnCloseListener;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	SectionsPagerAdapter mSectionsPagerAdapter;
	private SlidingMenu menu;
	ViewPager mViewPager;
	Context context;
	static ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		context = this;
		
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeAsUpIndicator(R.drawable.new_indicator_close);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager(), getResources(), this);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			switch (i) {
			case 0:
				actionBar.addTab(actionBar.newTab()
						.setCustomView(R.layout.tab_search)
						.setTabListener(this));
				break;
			case 1:
				actionBar.addTab(actionBar.newTab()
						.setCustomView(R.layout.tab_trending)
						.setTabListener(this));
				break;
			case 2:
				actionBar.addTab(actionBar.newTab()
						.setCustomView(R.layout.tab_feed).setTabListener(this));
				break;
			case 3:
				actionBar.addTab(actionBar.newTab()
						.setCustomView(R.layout.tab_earnpoints)
						.setTabListener(this));
				break;
			case 4:
				actionBar
						.addTab(actionBar.newTab()
								.setCustomView(R.layout.tab_avail)
								.setTabListener(this));
				break;

			}
		}

		menu = new SlidingMenu(this);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		menu.setMenu(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new SlidingMenuFragment()).commit();
		menu.setOnOpenListener(new OnOpenListener() {

			@Override
			public void onOpen() {
				actionBar.setHomeAsUpIndicator(R.drawable.new_indicator_open);
			}
		});

		menu.setOnCloseListener(new OnCloseListener() {

			@Override
			public void onClose() {
				actionBar.setHomeAsUpIndicator(R.drawable.new_indicator_close);
			}
		});

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			menu.toggle();
			break;
		case R.id.points:
			Toast.makeText(context,
					"you have " + item.getTitle().toString() + " points",
					Toast.LENGTH_LONG).show();
		}
		return true;
	}

	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onBackPressed() {
		if (menu.isMenuShowing()) {
			menu.showContent();
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public void moveToAvail(){
		actionBar.setSelectedNavigationItem(4);
	}
	
}
