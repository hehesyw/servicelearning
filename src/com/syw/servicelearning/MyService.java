package com.syw.servicelearning;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
/*
 * Service是一个后台服务的意思，它是一个抽象方法，需实现OnBind()方法，
 * 同时写程序需要复写父类的onCreate()、onStartCommand()、onDestroy()三个方法
 * 服务的开启和关闭很简单，startService()、stopService()
 * 在服务的任何一个位置调用stopSelf()可以让这个服务停止下来。
 * 为了能指挥service进行工作，需要使用onBind()服务。
 */
public class MyService extends Service {
	private DownloadBinder mBinder=new DownloadBinder();
	class DownloadBinder extends Binder{
		public void startDownload(){
			Log.d("TAG","startDownload executed");
		}
		public int getProgeress(){
			Log.d("TAG","getProgress executed");
			return 0;
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;//返回一个Binder对象实现对服务的控制
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("TAG", "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("TAG","onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("TAG","onDestroy");
	}
}
