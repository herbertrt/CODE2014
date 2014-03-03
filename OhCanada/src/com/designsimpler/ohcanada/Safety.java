package com.designsimpler.ohcanada;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Safety extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_safety);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.safety, menu);
		return true;
	}

	public void choosePolicePresence(View view) {
	    Intent intent = new Intent(this, PolicePresence.class);
	    startActivity(intent);
	}
}
