package com.juude.tracker;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgentJSInterface;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class StatisticService extends Service {

	protected static final String TAG = StatisticService.class.getSimpleName();

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		registerReceiver(mScreenReceiver, filter);
		MobclickAgent.onResume(this);

	}

	/* (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mScreenReceiver);
		MobclickAgent.onPause(this);
	}
	
	private BroadcastReceiver mScreenReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			final String action = intent.getAction();
			if(action.equals(Intent.ACTION_SCREEN_OFF)) {
				MobclickAgent.onEventEnd(context, "SCREEN_ON");
				MobclickAgent.onEvent(context, "EVENT");

				Log.d(TAG, "screenOff");
			}
			else if(action.equals(Intent.ACTION_SCREEN_ON)) {
				MobclickAgent.onEventBegin(context, "SCREEN_ON");
				MobclickAgent.onEvent(context, "EVENT");
				Log.d(TAG, "screenOn");
			}
		}
		
	};
}
