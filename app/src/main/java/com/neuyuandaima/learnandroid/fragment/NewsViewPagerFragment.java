package com.neuyuandaima.learnandroid.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neuyuandaima.learnandroid.R;

import java.util.ArrayList;

/**
 * Created by neuyuandaima on 2015/8/26.
 */
public class NewsViewPagerFragment extends Fragment{
	private View rootView;
	private ViewPager mViewPager;
	private PagerTabStrip mPagerTabStrip;
	private ArrayList<View> viewContainer=new ArrayList<View>();
	private ArrayList<String> titleContainer=new ArrayList<String>();
	private LayoutInflater mInflater;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.mInflater=inflater;
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
		//读取fragment 将fragment设置到list集合
		inflateFragmentNews();
		//将标题添加到集合
		initTitle2Container();
		//给viewpager设置adapter;
		viewpagerSetAdapter();

	}

	private void initTitle2Container() {
		String[] titles = getResources().getStringArray(R.array.news_viewpage_arrays);
		for (String title:titles) {
			titleContainer.add(title);
		}
	}

	private void inflateFragmentNews() {
		View blog=mInflater.inflate(R.layout.fragment_viewpage_news_blog, null);
		View news=mInflater.inflate(R.layout.fragment_viewpage_news_news, null);
		View blog2=mInflater.inflate(R.layout.fragment_viewpage_news_blog, null);
		View news2=mInflater.inflate(R.layout.fragment_viewpage_news_news, null);
		viewContainer.add(blog);
		viewContainer.add(news);
		viewContainer.add(blog2);
		viewContainer.add(news2);
	}

	private void setPagerTabStripProperty() {
		mPagerTabStrip.setDrawFullUnderline(false);
		mPagerTabStrip.setBackgroundColor(Color.WHITE);
		mPagerTabStrip.setTabIndicatorColor(getActivity().getResources().getColor(R.color.day_colorPrimary));
		mPagerTabStrip.setTextColor(getActivity().getResources().getColor(R.color.day_textColor));
	}

	//给viewpager设置adapter
	private void viewpagerSetAdapter() {
		mViewPager.setAdapter(new PagerAdapter() {

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
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return viewContainer.size();
			}
		});
	}

}
