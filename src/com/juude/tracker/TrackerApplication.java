package com.juude.tracker;

import com.umeng.analytics.MobclickAgent;

import android.app.Application;

public class TrackerApplication extends Application {

	/* (non-Javadoc)
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate() {
		MobclickAgent.setDebugMode(true);
		MobclickAgent.setEnableEventBuffer(true);
		MobclickAgent.updateOnlineConfig(this);
		MobclickAgent.openActivityDurationTrack(false);

		super.onCreate();
	}
	
	
	
}
