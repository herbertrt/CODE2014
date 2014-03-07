package com.designsimpler.ohcanada;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Safety extends Activity {

	
	public final static String EXTRA_URL = "com.designsimpler.ohcanada.URL";	
	public final static String EXTRA_CAT = "com.designsimpler.ohcanada.CATEGORY";	
	
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
	    Intent intent = new Intent(this, Results.class);
	    String url = "http://namara.io/api/v0/resources/7cb31a66-2f19-4c2a-9bdc-7176a342981c/data?api_key=097496a85611786bd3f1b6670ede38f814bdc56eaf569bda316f101aa5f172dc&order=%7B%22column%22:5,%22direction%22:0%7D&where=[%7B%22column%22:0,%22selector%22:%22eq%22,%22value%22:%222012%22%7D,%7B%22column%22:2,%22selector%22:%22eq%22,%22value%22:%22Police-civilian%20ratio%22%7D,%7B%22column%22:1,%22selector%22:%22ne%22,%22value%22:%22Canada%22%7D]&limit=10";
	    intent.putExtra(EXTRA_URL, url);
	    intent.putExtra(EXTRA_CAT, "Safety");
	    startActivity(intent);
	}
	
	public void chooseCrimeSeverity(View view) {
	    Intent intent = new Intent(this, Results.class);
	    String url = "http://namara.io/api/v0/resources/7cb31a66-2f19-4c2a-9bdc-7176a342981c/data?api_key=097496a85611786bd3f1b6670ede38f814bdc56eaf569bda316f101aa5f172dc&order=%7B%22column%22:5,%22direction%22:1%7D&where=[%7B%22column%22:0,%22selector%22:%22eq%22,%22value%22:%222011%22%7D,%7B%22column%22:2,%22selector%22:%22eq%22,%22value%22:%22Crime%20severity%20index%22%7D,%7B%22column%22:1,%22selector%22:%22ne%22,%22value%22:%22Canada%22%7D]&limit=10";
	    intent.putExtra(EXTRA_URL, url);
	    intent.putExtra(EXTRA_CAT, "Safety");
	    startActivity(intent);
	}}
