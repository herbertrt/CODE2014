package com.designsimpler.ohcanada;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View;

public class GridLayout extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {    
		super.onCreate(savedInstanceState);    
		setContentView(R.layout.activity_grid_layout);    
		GridView gridview = (GridView) findViewById(R.id.gridview);    
		gridview.setAdapter(new ImageAdapter(this));    
		gridview.setOnItemClickListener(new OnItemClickListener() {        
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {            
				Toast.makeText(GridLayout.this, "" + position, Toast.LENGTH_SHORT).show();        
			}    
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_grid_layout, menu);
		return true;
	}

}