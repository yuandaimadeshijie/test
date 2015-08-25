package com.neuyuandaima.learnandroid.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.neuyuandaima.learnandroid.base.BaseViewPagerFragment;
import com.neuyuandaima.learnandroid.interf.OnTabReselectListener;

/**
 * Created by neuyuandaima on 2015/8/21.
 */
public class NewsViewPagerFragment extends BaseViewPagerFragment implements OnTabReselectListener {
	protected ViewPager mViewPager;

	@Override
	public void onTabReselect() {
		try{
			int currentIndex=mViewPager.getCurrentItem();
			Fragment currentFragment=getChildFragmentManager().getFragments().get(currentIndex);
			if (currentFragment!=null&&currentFragment instanceof OnTabReselectListener){
				OnTabReselectListener listener=(OnTabReselectListener)currentFragment;
				listener.onTabReselect();
			}
		}catch(Exception e){

		}
	}
}
