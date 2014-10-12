package com.juude.tracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver{

	private static final String TAG = BootReceiver.class.getSimpleName();

	@Override
	public void onReceive(Context context, Intent arg1) {
		Log.d(TAG, "boot received");
		Intent i = new Intent();
		i.setClass(context, StatisticService.class);
		context.startService(i);
	}

}
