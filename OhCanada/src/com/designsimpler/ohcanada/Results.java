package com.designsimpler.ohcanada;


import java.io.*;
import java.net.*;
import org.json.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class Results extends Activity {

	
	ListView lvName;	
	String[] name;
	String error;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		Intent intent = getIntent();
	    String url = intent.getStringExtra(Safety.EXTRA_URL);

	    showDialogue(url);
		
		try {
			URL urlobj = new URL(url);
 
						
			URLConnection yc = urlobj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String inputLine=in.readLine();
			in.close();

			String FirstArrayString=null;
			JSONArray SecondArray=null;
			String element=null;
			JSONArray FirstArray = new JSONArray(inputLine);
			
			name = new String[FirstArray.length()];
    

			for(int j=0;j<FirstArray.length();j++)  

			{
				
				FirstArrayString= FirstArray.getJSONArray(j).toString();
				SecondArray = new JSONArray(FirstArrayString);
		
				for(int i=0;i< SecondArray.length();i++)		 
				{
		
			         element = SecondArray.get(i).toString();
			         if (i == 1)
			         	name[j] = element;
		
				}
			}
 
         
        } catch (MalformedURLException e) {
            error = "Malformed URL";
        } catch (IOException e1) {
            error = "IO Error";
        } catch (JSONException e2){
            error = "JSON Error";
		}
		if (error != null)
			showDialogue(error);

		
		lvName = (ListView) findViewById(R.id.cities);		
		lvName.setAdapter(new ArrayAdapter<String>(Results.this,
				android.R.layout.simple_list_item_1, name));		
		lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {			
			@Override			
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {				// TODO Auto-generated method stub				
				//Toast.makeText(getBaseContext(), name[position],  Toast.LENGTH_SHORT).show();			
			}		
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.police_presence, menu);
		return true;
	}
	
	private void showDialogue(String toShow){
		
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				this);

		alertDialog.setTitle("Reset...");
		alertDialog.setMessage("Test" + toShow);
		alertDialog.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int id) {
				// if yes is clicked, close
				// current activity
				Results.this.finish();
			}
		})
		.setNegativeButton("No",
		new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int id) {
				// if no is clicked, just close
				// the dialog box and do nothing
				dialog.cancel();
			}
		});

		AlertDialog alertDialog2 = alertDialog.create();

		alertDialog2.show(); 
	}

	

}
