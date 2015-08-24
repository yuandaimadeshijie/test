package com.neuyuandaima.learnandroid.widget;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;

/**
 * Created by neuyuandaima on 2015/8/21.
 */
public class MyFragmentTabHost extends FragmentTabHost{
	public MyFragmentTabHost(Context context) {
		super(context);
	}
	private String mCurrentTag;
	private String mNoTabChangedTag;

	@Override
	public void onTabChanged(String tabId) {
		if (tabId.equals(mNoTabChangedTag)){
			setCurrentTabByTag(mCurrentTag);
		}else {
			super.onTabChanged(tabId);
			mCurrentTag=tabId;
		}
	}
	public  void setmNoTabChangedTag(String tag){
		this.mCurrentTag=tag;
	}
}
