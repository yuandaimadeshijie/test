package com.neuyuandaima.learnandroid.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by neuyuandaima on 2015/8/27.
 */
public class MyPagerAdapter extends PagerAdapter{
	private ArrayList<View> viewContainer=new ArrayList<View>();
	private ArrayList<String> titleContainer=new ArrayList<String>();
	public MyPagerAdapter(ArrayList<View> viewContainer,ArrayList<String> titleContainer){
		this.viewContainer=viewContainer;
		this.titleContainer=titleContainer;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewContainer.get(position));
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewContainer.get(position));
		return viewContainer.get(position);
	}
	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titleContainer.get(position);
	}

	@Override
	public int getCount() {
		return viewContainer.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}
}
