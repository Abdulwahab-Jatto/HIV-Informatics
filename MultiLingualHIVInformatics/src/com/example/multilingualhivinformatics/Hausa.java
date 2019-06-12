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

public class Hausa extends Activity {

	TextToSpeech toSpeech;
	int result;
	TextView tvHA1;
	TextView tvHA2;
	TextView tvHA3;
	TextView tvHA4;
	TextView tvHA5;
	TextView tvHA6;
	TextView tvHA7;
	TextView tvHA8;
	TextView tvHA9;
	TextView tvHA10;
	String text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hausa);
		
		tvHA1 =  (TextView)findViewById(R.id.headHA1);
		tvHA2 =  (TextView)findViewById(R.id.notetxtHa1);
		
		tvHA3 =  (TextView)findViewById(R.id.headHA2);
		tvHA4 =  (TextView)findViewById(R.id.notetxtHa2);
		
		tvHA5 =  (TextView)findViewById(R.id.headHA3);
		tvHA6 =  (TextView)findViewById(R.id.notetxtHa3);
		
		tvHA7 =  (TextView)findViewById(R.id.headHA4);
		tvHA8 =  (TextView)findViewById(R.id.notetxtHa4);
		
		tvHA9 =  (TextView)findViewById(R.id.headHA5);
		tvHA10 =  (TextView)findViewById(R.id.notetxtHa5);
		
		toSpeech = new TextToSpeech(Hausa.this, new TextToSpeech.OnInitListener() {
			
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
		case R.id.bSpeakHa:
			if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
				Toast.makeText(getApplicationContext(), "Features not supported in your language", Toast.LENGTH_SHORT).show();
				
			}
			else{
				text = tvHA1.getText().toString()+tvHA2.getText().toString()+tvHA3.getText().toString()+tvHA4.getText().toString()+tvHA5.getText().toString()+
						tvHA6.getText().toString()+tvHA7.getText().toString()+tvHA8.getText().toString()+tvHA9.getText().toString()+tvHA10.getText().toString();
				toSpeech.setSpeechRate((float)0.7);
				
				toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
							}
			break;
		case R.id.bStopHa:
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
