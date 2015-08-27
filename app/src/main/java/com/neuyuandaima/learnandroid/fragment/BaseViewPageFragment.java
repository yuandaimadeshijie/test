package com.neuyuandaima.learnandroid.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neuyuandaima.learnandroid.R;

/**
 * Created by neuyuandaima on 2015/8/27.
 */
public class BaseViewPageFragment extends Fragment{
	private View rootView;
	private ViewPager mViewPager;
	private PagerTabStrip mPagerTabStrip;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (rootView==null) {
			rootView = inflater.inflate(R.layout.base_viewpage_fragment, container, false);
		}
		ViewGroup parent=(ViewGroup)rootView.getParent();
		if (parent!=null){
			parent.removeView(rootView);
		}
		return  rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mViewPager=(ViewPager)view.findViewById(R.id.viewpager);
		mPagerTabStrip=(PagerTabStrip)view.findViewById(R.id.tabstrip);
		//设置pagertabstrip属性
		setPagerTabStripProperty();
	}
	private void setPagerTabStripProperty() {
		mPagerTabStrip.setDrawFullUnderline(false);
		mPagerTabStrip.setBackgroundColor(Color.WHITE);
		mPagerTabStrip.setTabIndicatorColor(getActivity().getResources().getColor(R.color.day_colorPrimary));
		mPagerTabStrip.setTextColor(getActivity().getResources().getColor(R.color.day_textColor));
	}
	protected ViewPager getViewPager(){
		return mViewPager;
	}
}
