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

public class Yoruba extends Activity {

	TextToSpeech toSpeech;
	int result;
	TextView tvYO1;
	TextView tvYO2;
	TextView tvYO3;
	TextView tvYO4;
	TextView tvYO5;
	TextView tvYO6;
	TextView tvYO7;
	TextView tvYO8;
	TextView tvYO9;
	TextView tvYO10;
	String text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yoruba);
		
		tvYO1 =  (TextView)findViewById(R.id.headYO1);
		tvYO2 =  (TextView)findViewById(R.id.notetxtYo1);
		
		tvYO3 =  (TextView)findViewById(R.id.headYO2);
		tvYO4 =  (TextView)findViewById(R.id.notetxtYo2);
		
		tvYO5 =  (TextView)findViewById(R.id.headYO3);
		tvYO6 =  (TextView)findViewById(R.id.notetxtYo3);
		
		tvYO7 =  (TextView)findViewById(R.id.headYO4);
		tvYO8 =  (TextView)findViewById(R.id.notetxtYo4);
		
		tvYO9 =  (TextView)findViewById(R.id.headYO5);
		tvYO10 =  (TextView)findViewById(R.id.notetxtYo5);
		
		toSpeech = new TextToSpeech(Yoruba.this, new TextToSpeech.OnInitListener() {
			
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
		case R.id.bSpeakYo:
			if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
				Toast.makeText(getApplicationContext(), "Features not supported in your language", Toast.LENGTH_SHORT).show();
				
			}
			else{
				text = tvYO1.getText().toString()+tvYO2.getText().toString()+tvYO3.getText().toString()+tvYO4.getText().toString()+tvYO5.getText().toString()+
						tvYO6.getText().toString()+tvYO7.getText().toString()+tvYO8.getText().toString()+tvYO9.getText().toString()+tvYO10.getText().toString();
				toSpeech.setSpeechRate((float)0.7);
				toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
							}
			break;
		case R.id.bStopYo:
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

