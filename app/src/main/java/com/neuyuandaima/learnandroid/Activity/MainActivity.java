package com.neuyuandaima.learnandroid.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.neuyuandaima.learnandroid.AppManager;
import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.ui.MainTab;
import com.neuyuandaima.learnandroid.ui.NavigationDrawerFragment;
import com.neuyuandaima.learnandroid.widget.MyFragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks
									,View.OnTouchListener,TabHost.OnTabChangeListener{
	private NavigationDrawerFragment mNavigationDrawerFragment;
	 @Bind(android.R.id.tabhost)MyFragmentTabHost mTabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		initView();
		AppManager.getInstance().addActivity(this);
		ActionBar ab = getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setHomeButtonEnabled(true);
	}


	private void initView() {
		mNavigationDrawerFragment=(NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.getTabWidget().setShowDividers(0);
		initTab();
		mTabHost.setCurrentTab(0);
		mTabHost.setOnTabChangedListener(this);
	}

	private void initTab() {
		MainTab[] tabs=MainTab.values();
		final  int size=tabs.length;
		for (int i=0;i<size;i++){
			MainTab mainTab=tabs[i];
			TabHost.TabSpec tab=mTabHost.newTabSpec(getString(mainTab.getResName()));
			View indicator= LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_indicator, null);
			TextView title=(TextView)indicator.findViewById(R.id.tab_title);
			Drawable drawable=this.getResources().getDrawable(mainTab.getResIcon());
			title.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);
			if (i==2){
				indicator.setVisibility(View.INVISIBLE);
				mTabHost.setmNoTabChangedTag(getString(mainTab.getResName()));
			}
			title.setText(getString(mainTab.getResName()));
			tab.setIndicator(indicator);
			tab.setContent(new TabHost.TabContentFactory() {
				@Override
				public View createTabContent(String tag) {
					return new View(MainActivity.this);
				}
			});

			mTabHost.addTab(tab,mainTab.getCls(),null);
			mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity_menu, menu);

		if (!mNavigationDrawerFragment.isDrawerOpen()){
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	public void restoreActionBar(){
		ActionBar bar=getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		bar.setDisplayShowTitleEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.search:
				Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
				break;
			case android.R.id.home:
				if (mNavigationDrawerFragment.isDrawerOpen()){
					mNavigationDrawerFragment.closeDrawerMenu();
				}else {
					mNavigationDrawerFragment.openDrawerMenu();
				}
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}

	@Override
	public void onTabChanged(String tabId) {

	}
}