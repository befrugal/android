package com.app.closeout;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.Gravity;
import android.widget.Toast;

public class UtilTwitter {
	public static boolean shareTwitter(Activity activity,
			String message) {
		String shareText = message;
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.setType("text/plain");
		sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
		sendIntent.setPackage("com.twitter.android");
		if (UtilTwitter.isCallable(sendIntent, activity)) {
			UtilTwitter.showMessage(activity,
					activity.getResources().getString(R.string.launch_twtr));
			activity.startActivity(sendIntent);
			return true;
		} else {
			UtilTwitter.showMessage(
					activity,
					activity.getResources().getString(
							R.string.not_installed_twtr));
			return false;
		}
	}

	public static boolean isCallable(Intent intent, Context context) {
		if (context == null) {
			return false;
		}
		List<ResolveInfo> list = context.getPackageManager()
				.queryIntentActivities(intent,
						PackageManager.MATCH_DEFAULT_ONLY);
		if (list == null) {
			return false;
		}
		return list.size() > 0;
	}

	public static void showMessage(Context context, String message) {
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
