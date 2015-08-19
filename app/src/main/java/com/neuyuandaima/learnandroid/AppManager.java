package com.neuyuandaima.learnandroid;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by neuyuandaima on 2015/8/19.
 */
public class AppManager {
	private static  AppManager instance;
	private static Stack<Activity> activities;
	private AppManager(){}
	public  static AppManager getInstance(){
		if (instance==null){
			instance=new AppManager();
		}
		return instance;
	}
	/**
	 * 添加Activity到堆栈
	 */
	public  void addActivity(Activity activity){
		if (activities==null){
			activities=new Stack<Activity>();
		}
		activities.add(activity);
	}
	/*
		获的当前的activity
	 */
	public Activity currentActivity(){
		Activity activity=activities.lastElement();
		return activity;
	}
	/*
		结束当前activity
	 */
	public void finishActiivty(){
		Activity activity=activities.lastElement();
		finishActiivty(activity);
	}
	/*
		获取指定activity
	 */
	public static Activity getActivity(Class<?> cls){
		if (activities!=null){
			for (Activity activity:activities) {
				if (activity.getClass().equals(cls)){
					return activity;
				}
			}
		}
			return null;
	}
	/*
		结束指定的activity
	 */
	public void finishActiivty(Activity activity){
		if (activity!=null&&!activity.isFinishing()){
			activities.remove(activity);
			activity.finish();
			activity=null;
		}
	}
	/*
		结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls){
		for (Activity activity:activities) {
			if (activity.getClass().equals(cls)){
				finishActiivty(activity);
			}
		}
	}
	/*
		删除所有activity
	 */
	public void finishAllActivity(){
		for (int i=0;i<activities.size();i++){
			if (null!=activities.get(i)){
				finishActiivty(activities.get(i));
			}
		}
		activities.clear();
	}
	/*
		退出程序
	 */
	public void AppExit(Context context){
		try{
			finishAllActivity();
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(0);
		}catch(Exception e){

		}
	}

}
