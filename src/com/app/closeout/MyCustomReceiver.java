package com.app.closeout;

import org.json.JSONException;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyCustomReceiver extends BroadcastReceiver {
	private static final String TAG = "MyCustomReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, "Here in custom handler",
				duration);

		final int NOTIFICATION_ID = 1;
		NotificationManager mNotificationManager;
		NotificationCompat.Builder builder;
		mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Bundle extras = new Bundle();
		Intent notificationIntent = new Intent(context, MainActivity.class);

		notificationIntent.putExtra("notification", extras);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		// Adds the back stack
		// stackBuilder.addParentStack(OffersAcitvity.class);
		// Adds the Intent to the top of the stack
		stackBuilder.addNextIntent(notificationIntent);
		// Gets a PendingIntent containing the entire back stack
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
				0, PendingIntent.FLAG_UPDATE_CURRENT);

		long[] vibratePattern = { 0, 500, 1000 };
		Uri notificationSound = RingtoneManager
				.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setContentTitle("Copper Chimney")
				.setAutoCancel(true).setVibrate(vibratePattern)
				.setSound(notificationSound);

		mBuilder.setContentIntent(resultPendingIntent);
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}
}