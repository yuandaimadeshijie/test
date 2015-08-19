package com.neuyuandaima.learnandroid.ui;

import android.view.View;

import com.neuyuandaima.learnandroid.base.BaseFragment;

/**
 * Created by neuyuandaima on 2015/8/19.
 */
public class NavigationDrawerFragment extends BaseFragment implements View.OnClickListener{







	public interface NavigationDrawerCallbacks{
		void onNavigationDrawerItemSelected(int position);
	}
}
