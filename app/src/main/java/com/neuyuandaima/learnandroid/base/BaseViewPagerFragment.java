package com.neuyuandaima.learnandroid.base;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.widget.PagerSlidingTabStrip;

/**
 * Created by neuyuandaima on 2015/8/21.
 */
public class BaseViewPagerFragment extends BaseFragment {
	protected PagerSlidingTabStrip mTabStrip;
	protected ViewPager mViewPager;
	protected ViewPageFragmentAdapter mTabsAdapter;
	protected EmptyLayout mErrorLayout;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.base_viewpage_fragment,container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		mTabStrip=(PagerSlidingTabStrip)view.findViewById(R.id.pager_tabstrip);
		mViewPager=(ViewPager)view.findViewById(R.id.pager);
		mErro
	}
}
