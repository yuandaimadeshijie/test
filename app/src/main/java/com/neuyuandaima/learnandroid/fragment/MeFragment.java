package com.neuyuandaima.learnandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by neuyuandaima on 2015/8/27.
 */
public class MeFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView textView=new TextView(getActivity());
		textView.setText("hello");
		return  textView;
	}
}
