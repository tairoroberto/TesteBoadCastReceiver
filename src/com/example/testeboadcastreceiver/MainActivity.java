package com.example.testeboadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Registra o BroadcastReceiverTwo
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("BROADCAST_RECEIVER_API");
		intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
		
		registerReceiver(new BroadcastReceiverTwo(), intentFilter);
	}
	
	
	
	public void chamarBR(View view) {
		Button btn = (Button)view;
		//Intent para enviar broadcast
		Intent intent = new Intent(btn.getText().toString());
		
		sendBroadcast(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//destroi o broadcastreceiver quando a app for finalizada
		unregisterReceiver(new BroadcastReceiverTwo());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
