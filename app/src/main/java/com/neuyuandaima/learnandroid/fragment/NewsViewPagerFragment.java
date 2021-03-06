package com.neuyuandaima.learnandroid.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.adapter.MyPagerAdapter;

import java.util.ArrayList;

/**
 * Created by neuyuandaima on 2015/8/26.
 */
public class NewsViewPagerFragment extends BaseViewPageFragment {
	private ArrayList<View> viewContainer=new ArrayList<View>();
	private ArrayList<String> titleContainer=new ArrayList<String>();
	private LayoutInflater mInflater;
	private ViewPager mViewPager;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			this.mInflater=inflater;
			return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		//读取fragment 将fragment设置到list集合
		inflateFragmentNews();
		//将标题添加到集合
		initTitle2Container();
		//获取viewpager和给viewpager设置adapter;
		mViewPager=getViewPager();
		mViewPager.setAdapter(new MyPagerAdapter(viewContainer,titleContainer));

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
}
