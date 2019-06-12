package com.example.multilingualhivinformatics;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class English extends Activity {

	TextToSpeech toSpeech;
	int result;
	TextView tvEN1;
	TextView tvEN2;
	TextView tvEN3;
	TextView tvEN4;
	TextView tvEN5;
	TextView tvEN6;
	TextView tvEN7;
	TextView tvEN8;
	TextView tvEN9;
	TextView tvEN10;
	String text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_english);
		
		tvEN1 =  (TextView)findViewById(R.id.headEN1);
		tvEN2 =  (TextView)findViewById(R.id.notetxtEn1);
		
		tvEN3 =  (TextView)findViewById(R.id.headEN2);
		tvEN4 =  (TextView)findViewById(R.id.notetxtEn2);
		
		tvEN5 =  (TextView)findViewById(R.id.headEN3);
		tvEN6 =  (TextView)findViewById(R.id.notetxtEn3);
		
		tvEN7 =  (TextView)findViewById(R.id.headEN4);
		tvEN8 =  (TextView)findViewById(R.id.notetxtEn4);
		
		tvEN9 =  (TextView)findViewById(R.id.headEN5);
		tvEN10 =  (TextView)findViewById(R.id.notetxtEn5);
		
		toSpeech = new TextToSpeech(English.this, new TextToSpeech.OnInitListener() {
			
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
		case R.id.bSpeakEn:
			if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
				Toast.makeText(getApplicationContext(), "Features not supported in your language", Toast.LENGTH_SHORT).show();
				
			}
			else{
				text = tvEN1.getText().toString()+tvEN2.getText().toString()+tvEN3.getText().toString()+tvEN4.getText().toString()+tvEN5.getText().toString()+
						tvEN6.getText().toString()+tvEN7.getText().toString()+tvEN8.getText().toString()+tvEN9.getText().toString()+tvEN10.getText().toString();
				toSpeech.setSpeechRate((float)0.7);
				toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
							}
			break;
		case R.id.bStopEn:
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
