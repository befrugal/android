package com.app.closeout.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.closeout.R;
import com.app.closeout.fragments.FragmentAvail;
import com.app.closeout.fragments.FragmentEarnPoints;
import com.app.closeout.fragments.FragmentFeed;
import com.app.closeout.fragments.FragmentSearch;
import com.app.closeout.fragments.FragmentTrending;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

	Resources res;
	Context context;

	public SectionsPagerAdapter(FragmentManager fm, Resources res, Context context) {
		super(fm);
		this.res = res;
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a DummySectionFragment (defined as a static inner class
		// below) with the page number as its lone argument.
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new FragmentSearch();
			break;
		case 1:
			fragment = new FragmentTrending(context);
			break;
		case 2:
			fragment = new FragmentFeed();
			break;
		case 3:
			fragment = new FragmentEarnPoints();
			break;
		case 4:
			fragment = new FragmentAvail();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// Show 5 total pages.
		return 5;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return res.getString(R.string.title_search);
		case 1:
			return res.getString(R.string.title_trending);
		case 2:
			return res.getString(R.string.title_feeds);
		case 3:
			return res.getString(R.string.title_avail);
		case 4:
			return res.getString(R.string.title_earnpoints);
		}
		return null;
	}
}
