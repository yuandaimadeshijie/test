package com.neuyuandaima.learnandroid.ui;

import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.fragment.NewsViewPagerFragment;

/**
 * Created by neuyuandaima on 2015/8/21.
 */
public enum  MainTab {
	NEWS(0,R.string.main_tab_name_news, R.drawable.tab_icon_new, NewsViewPagerFragment.class);
	private int index;
	private int resName;
	private int resIcon;
	private Class<?> cls;
	private MainTab(int index,int resName,int resIcon,Class<?> cls){
		this.index=index;
		this.resName=resName;
		this.resIcon=resIcon;
		this.cls=cls;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}
}
