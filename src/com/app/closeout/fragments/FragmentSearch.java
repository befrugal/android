package com.app.closeout.fragments;

import java.util.HashMap;

import net.sourceforge.zbar.Symbol;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.closeout.AsyncNetwork;
import com.app.closeout.MainActivity;
import com.app.closeout.R;
import com.app.closeout.UtilFacebook;
import com.app.closeout.UtilTwitter;
import com.dm.zbar.android.scanner.ZBarConstants;
import com.dm.zbar.android.scanner.ZBarScannerActivity;

public class FragmentSearch extends Fragment implements OnClickListener {

	Context context;
	Button qrScanButton;
	Activity activity;
	private static final int ZBAR_QR_SCANNER_REQUEST = 1;
	static String URL;
	static String rewardType;

	public FragmentSearch() {
	}

	@Override
	public void onAttach(Activity activity) {
		context = activity.getApplicationContext();
		this.activity = activity;
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

		qrScanButton = (Button) layout_search.findViewById(R.id.button_qrscan);

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
		case R.id.button_qrscan:
			if (isCameraAvailable()) {
				Intent intent = new Intent(context, ZBarScannerActivity.class);
				intent.putExtra(ZBarConstants.SCAN_MODES,
						new int[] { Symbol.QRCODE });
				startActivityForResult(intent, ZBAR_QR_SCANNER_REQUEST);
			} else {
				Toast.makeText(context, "Rear Facing Camera Unavailable",
						Toast.LENGTH_LONG).show();
			}
			break;
		}
	}

	public boolean isCameraAvailable() {
		PackageManager pm = context.getPackageManager();
		return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == android.app.Activity.RESULT_OK) {
			// Scan result is available by making a call to
			// data.getStringExtra(ZBarConstants.SCAN_RESULT)
			// Type of the scan result is available by making a call to
			// data.getStringExtra(ZBarConstants.SCAN_RESULT_TYPE)
			/*
			 * Toast.makeText( context, "Scan Result = " +
			 * data.getStringExtra(ZBarConstants.SCAN_RESULT),
			 * Toast.LENGTH_SHORT).show(); Toast.makeText( context,
			 * "Scan Result Type = " +
			 * data.getIntExtra(ZBarConstants.SCAN_RESULT_TYPE, 0),
			 * Toast.LENGTH_SHORT).show();
			 */
			// The value of type indicates one of the symbols listed in Advanced
			// Options below.
			String qrcode_data = data.getStringExtra(ZBarConstants.SCAN_RESULT);
			String[] arr = qrcode_data.split(";");
			HashMap<String, String> map = new HashMap<String, String>();
			for (String tmpString : arr) {
				map.put(tmpString.split("=")[0], tmpString.split("=")[1]);
			}
			rewardType = map.get("reward_type");
			URL = "http://sequoiahack.herokuapp.com/data?rId=" + map.get("rId").toUpperCase()
					+ "&tableNo=" + map.get("tableNo");

			final String twtrText = map.get("tw_text");
			new AlertDialog.Builder(activity)
					.setTitle("Share")
					.setMessage(
							"Share on Twitter or Facebook to avail "
									+ rewardType + "?")
					.setPositiveButton(R.string.twitter,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									UtilTwitter
											.shareTwitter(activity, twtrText);
									MainActivity.fromTwitter = true;
								}
							})
					.setNegativeButton(R.string.facebook,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									UtilFacebook u = new UtilFacebook();
									u.shareIt(getView(), activity);
									MainActivity.fromTwitter = true;
								}
							}).setIcon(android.R.drawable.ic_dialog_alert)
					.show();

		} else if (resultCode == android.app.Activity.RESULT_CANCELED) {
			// Toast.makeText(context, "Camera unavailable", Toast.LENGTH_LONG)
			// .show();
		}
	}

	public void afterTwitter(Context context) {

		try {
			String x = new AsyncNetwork().execute(URL).get();
			System.out.println("response is " + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(rewardType.equals("200 Cash Coins")){
			MainActivity.updatePoints();
		}

		if (!rewardType.equals("Surprise Gift")) {
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
					context).setSmallIcon(R.drawable.frugal_small)
					.setContentTitle("Here's your Reward")
					.setContentText(rewardType);
			// Creates an explicit intent for an Activity in your app
			Intent resultIntent = new Intent(context, MainActivity.class);

			// The stack builder object will contain an artificial back stack
			// for the
			// started Activity.
			// This ensures that navigating backward from the Activity leads out
			// of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack(MainActivity.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
					0, PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager = (NotificationManager) context
					.getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(1, mBuilder.build());
		}

	}

}
