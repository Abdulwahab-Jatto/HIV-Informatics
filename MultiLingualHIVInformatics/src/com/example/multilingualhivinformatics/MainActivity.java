package com.example.multilingualhivinformatics;

import android.support.v7.app.ActionBarActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	
	private Button en;
	private Button ha;
	private Button ig;
	private Button yo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		en = (Button)findViewById(R.id.buttonEn);
		ha = (Button)findViewById(R.id.buttonHa);
		ig = (Button)findViewById(R.id.buttonIg);
		yo = (Button)findViewById(R.id.buttonYo);
		
en.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivityEn();
				
			}
		});
		
ha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openActivityHa();
				
			}
		});

ig.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		openActivityIg();
		
	}
});

yo.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		openActivityYo();
		
	}
});
	}
public void openActivityEn(){
		Intent intent = new Intent(this,English.class);
		startActivity(intent);
	
}

public void openActivityHa(){
	Intent intent = new Intent(this,Hausa.class);
	startActivity(intent);

}

public void openActivityIg(){
	Intent intent = new Intent(this,Igbo.class);
	startActivity(intent);

}

public void openActivityYo(){
	Intent intent = new Intent(this,Yoruba.class);
	startActivity(intent);

}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
