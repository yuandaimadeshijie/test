package com.neuyuandaima.learnandroid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neuyuandaima.learnandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by neuyuandaima on 2015/8/19.
 */
public class NavigationDrawerFragment extends Fragment implements View.OnClickListener{
	private View mDrawerListView;
	private DrawerLayout mDrawerLayout;
	private View mFragmentContainerView;
	private ActionBarDrawerToggle mDrawerToggle;
	private int mCurrentSelectedPosition = 0;
	private NavigationDrawerCallbacks mCallbacks;
	@Bind(R.id.menu_item_blog)View mMenu_item_bolg;
	@Bind(R.id.menu_item_git)View mMenu_item_git;
	@Bind(R.id.menu_item_opensoft)View mMenu_item_opensoft;
	@Bind(R.id.menu_item_quests)View mMenu_item_quests;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		selectItem(mCurrentSelectedPosition);
	}

	private void selectItem(int position) {
		mCurrentSelectedPosition = position;
		if (mDrawerLayout!=null){
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		if (mCallbacks!=null){
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mDrawerListView=inflater.inflate(R.layout.fragment_navigation_drawer,container,false);
		mDrawerListView.setOnClickListener(this);
		ButterKnife.bind(this, mDrawerListView);
		return mDrawerListView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mMenu_item_bolg.setOnClickListener(this);
		mMenu_item_git.setOnClickListener(this);
		mMenu_item_opensoft.setOnClickListener(this);
		mMenu_item_quests.setOnClickListener(this);
	}

	public void openDrawerMenu() {
		mDrawerLayout.openDrawer(mFragmentContainerView);
	}
	public void closeDrawerMenu(){mDrawerLayout.closeDrawer(mFragmentContainerView);}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.menu_item_quests:

		}
		mDrawerLayout.postDelayed(new Runnable() {
			@Override
			public void run() {
				mDrawerLayout.closeDrawers();
			}
		}, 800);
	}
	public void setUp(int fragmentId,DrawerLayout drawerLayout){
		mFragmentContainerView=getActivity().findViewById(fragmentId);
		mDrawerLayout=drawerLayout;

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		ActionBar actionBar=getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		mDrawerToggle=new ActionBarDrawerToggle(getActivity(),mDrawerLayout,null
						,R.string.drawer_open,R.string.drawer_close){
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActivity().invalidateOptionsMenu();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				getActivity().invalidateOptionsMenu();
			}
		};

		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});
		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}
	public boolean isDrawerOpen() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}
	}

	private ActionBar getActionBar(){
		return ((AppCompatActivity) getActivity()).getSupportActionBar();
	}
	public interface NavigationDrawerCallbacks{
		void onNavigationDrawerItemSelected(int position);
	}
}
