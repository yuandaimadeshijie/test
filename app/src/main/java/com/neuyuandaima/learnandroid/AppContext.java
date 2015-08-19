package com.neuyuandaima.learnandroid;

import com.neuyuandaima.learnandroid.base.BaseApplication;

/**
 * Created by neuyuandaima on 2015/8/19.
 */
public class AppContext extends BaseApplication{

	private  static AppContext instance;
	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
	}


	public static AppContext getInstance(){return instance;}

}
