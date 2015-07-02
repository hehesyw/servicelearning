package com.syw.servicelearning;

import com.syw.servicelearning.MyService.DownloadBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button stopBtn;
	private Button startBtn;
	private Button bindBtn;
	private Button unbindBtn;
	private MyService.DownloadBinder downloadBinder;
	private ServiceConnection connection=new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		@Override
		/*
		 * SericeConnetion是一个接口，在这里可以得到返回的Binder对象，同时也是服务绑定必须参数。
		 */
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			downloadBinder=(DownloadBinder) service;
			downloadBinder.startDownload();
			downloadBinder.getProgeress();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startBtn = (Button) findViewById(R.id.start_service);
		stopBtn = (Button) findViewById(R.id.stop_service);
		bindBtn = (Button) findViewById(R.id.bind_service);
		unbindBtn = (Button) findViewById(R.id.unbind_service);
		startBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);
		bindBtn.setOnClickListener(this);
		unbindBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start_service:
			Intent i = new Intent(MainActivity.this, MyService.class);
			startService(i);
			break;
		case R.id.stop_service:
			Intent ii = new Intent(MainActivity.this, MyService.class);
			stopService(ii);
			break;
		case R.id.bind_service:
			Intent bindIntent=new Intent(this,MyService.class);
			bindService(bindIntent, connection,BIND_AUTO_CREATE);//BIND_AUTO_CREATE表明服务绑定后立即创建服务
			
			break;
		case R.id.unbind_service:
			unbindService(connection);
			break;
		}
	}

}
