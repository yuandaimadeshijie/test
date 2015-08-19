package com.neuyuandaima.learnandroid.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by neuyuandaima on 2015/8/19.
 */
public class BaseApplication extends Application{
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context=getApplicationContext();
	}
	public static synchronized BaseApplication getContext(){
		return  (BaseApplication)context;
	}
}
