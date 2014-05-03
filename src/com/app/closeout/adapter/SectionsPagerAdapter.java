package com.app.closeout.adapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.closeout.R;
import com.app.closeout.fragments.FragmentAvail;
import com.app.closeout.fragments.FragmentEarnPoints;
import com.app.closeout.fragments.FragmentFeed;
import com.app.closeout.fragments.FragmentNearby;
import com.app.closeout.fragments.FragmentSearch;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	Resources res;

	public SectionsPagerAdapter(FragmentManager fm, Resources res) {
		super(fm);
		this.res = res;
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
			fragment = new FragmentNearby();
			break;
		case 2:
			fragment = new FragmentFeed();
			break;
		case 3:
			fragment = new FragmentAvail();
			break;
		case 4:
			fragment = new FragmentEarnPoints();
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
			return res.getString(R.string.title_nearby);
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
