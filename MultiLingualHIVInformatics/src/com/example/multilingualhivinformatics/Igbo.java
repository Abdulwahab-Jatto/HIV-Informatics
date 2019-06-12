package com.example.multilingualhivinformatics;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Igbo extends Activity {

	TextToSpeech toSpeech;
	int result;
	TextView tvIG1;
	TextView tvIG2;
	TextView tvIG3;
	TextView tvIG4;
	TextView tvIG5;
	TextView tvIG6;
	TextView tvIG7;
	TextView tvIG8;
	TextView tvIG9;
	TextView tvIG10;
	String text;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_igbo);
		tvIG1 =  (TextView)findViewById(R.id.headIG1);
		tvIG2 =  (TextView)findViewById(R.id.notetxtIg1);
		
		tvIG3 =  (TextView)findViewById(R.id.headIG2);
		tvIG4 =  (TextView)findViewById(R.id.notetxtIg2);
		
		tvIG5 =  (TextView)findViewById(R.id.headIG3);
		tvIG6 =  (TextView)findViewById(R.id.notetxtIg3);
		
		tvIG7 =  (TextView)findViewById(R.id.headIG4);
		tvIG8 =  (TextView)findViewById(R.id.notetxtIg4);
		
		tvIG9 =  (TextView)findViewById(R.id.headIG5);
		tvIG10 =  (TextView)findViewById(R.id.notetxtIg5);
		
		toSpeech = new TextToSpeech(Igbo.this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int arg0) {
				if(arg0 == TextToSpeech.SUCCESS){
					result = toSpeech.setLanguage(Locale.US);
									}
				else{
					Toast.makeText(getApplicationContext(), "Features not supported in your language", Toast.LENGTH_SHORT).show();
					
				}
			}
		});

	}
	
	@SuppressWarnings("deprecation")
	public void TTS(View view){
		switch(view.getId()){
		case R.id.bSpeakIg:
			if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
				Toast.makeText(getApplicationContext(), "Features not supported in your language", Toast.LENGTH_SHORT).show();
				
			}
			else{
				text = tvIG1.getText().toString()+tvIG2.getText().toString()+tvIG3.getText().toString()+tvIG4.getText().toString()+tvIG5.getText().toString()+
						tvIG6.getText().toString()+tvIG7.getText().toString()+tvIG8.getText().toString()+tvIG9.getText().toString()+tvIG10.getText().toString();
				
				toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
							}
			break;
		case R.id.bStopIg:
			if(toSpeech != null){
				toSpeech.stop();
			}
			break;
		}
		
	}
	
	protected void onDestroy(){
		super.onDestroy();
		if(toSpeech != null){
			toSpeech.stop();
			toSpeech.shutdown();
		}
	}
}

