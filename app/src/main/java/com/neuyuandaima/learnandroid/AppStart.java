package com.neuyuandaima.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.neuyuandaima.learnandroid.activity.MainActivity;

public class AppStart extends Activity implements Animation.AnimationListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_start);
		//单例模式
		Activity activity=AppManager.getActivity(MainActivity.class);
		if (activity!=null&&!activity.isFinishing()){
			finish();
		}
		final View view=View.inflate(this,R.layout.activity_app_start,null);
		setContentView(view);
		//渐变
		AlphaAnimation animation=new AlphaAnimation(0.5f, 1.0f);
		animation.setDuration(800);
		view.startAnimation(animation);
		animation.setAnimationListener(this);
	}
	/*
		跳转到
	 */
	private void redirectTo(){
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void onAnimationStart(Animation animation) {
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		redirectTo();
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
	}

}
