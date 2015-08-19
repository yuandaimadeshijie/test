package com.neuyuandaima.learnandroid.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;

import com.neuyuandaima.learnandroid.AppManager;
import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.ui.NavigationDrawerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements TabHost.OnTabChangeListener,View.OnClickListener,View.OnTouchListener{
	@Bind(R.id.drawer_layout)DrawerLayout drawerLayout;
	@Bind(R.id.navigation_drawer)NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		initView();
		AppManager.getInstance().addActivity(this);
	}

	private void initView() {
		mTitle=getTitle();
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onTabChanged(String tabId) {

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}
}