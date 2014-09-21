package com.app.closeout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

public class UtilFacebook {
	public void shareIt(View view, Activity activity) {
		// sharing implementation
		//String shareText = message;
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.setType("text/plain");
		sendIntent.putExtra(Intent.EXTRA_TEXT, "sharing facebook status");
		sendIntent.setPackage("com.facebook.katana");
		if (UtilTwitter.isCallable(sendIntent, activity)) {
			UtilTwitter.showMessage(activity,
					activity.getResources().getString(R.string.launch_twtr));
			activity.startActivity(sendIntent);
		} else {
			UtilTwitter.showMessage(
					activity,
					activity.getResources().getString(
							R.string.not_installed_twtr));
		}
	}
}
