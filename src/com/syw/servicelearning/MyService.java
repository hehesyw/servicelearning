package com.syw.servicelearning;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
/*
 * Service��һ����̨�������˼������һ�����󷽷�����ʵ��OnBind()������
 * ͬʱд������Ҫ��д�����onCreate()��onStartCommand()��onDestroy()��������
 * ����Ŀ����͹رպܼ򵥣�startService()��stopService()
 * �ڷ�����κ�һ��λ�õ���stopSelf()�������������ֹͣ������
 * Ϊ����ָ��service���й�������Ҫʹ��onBind()����
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
		return mBinder;//����һ��Binder����ʵ�ֶԷ���Ŀ���
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
