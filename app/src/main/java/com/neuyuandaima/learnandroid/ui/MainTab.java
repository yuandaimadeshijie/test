package com.neuyuandaima.learnandroid.ui;

import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.fragment.NewsViewPagerFragment;


public enum MainTab {

	NEWS(0, R.string.main_tab_name_news, R.drawable.tab_icon_new,
			NewsViewPagerFragment.class),

	TWEET(1, R.string.main_tab_name_tweet, R.drawable.tab_icon_tweet,
			NewsViewPagerFragment.class),


	EXPLORE(2, R.string.main_tab_name_explore, R.drawable.tab_icon_explore,
			NewsViewPagerFragment.class),

	ME(3, R.string.main_tab_name_my, R.drawable.tab_icon_me,
			NewsViewPagerFragment.class);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> cls;

	private MainTab(int idx, int resName, int resIcon, Class<?> cls) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.cls = cls;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
}
