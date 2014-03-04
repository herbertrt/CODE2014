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
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class PolicePresence extends Activity {

	
	ListView lvName;	
	String[] name;
	String error;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_police_presence);
		
		
		try {
			URL urlobj = new URL(" http://namara.io/api/v0/resources/7cb31a66-2f19-4c2a-9bdc-7176a342981c/data?api_key=097496a85611786bd3f1b6670ede38f814bdc56eaf569bda316f101aa5f172dc&order=%7B%22column%22:5,%22direction%22:0%7D&where=[%7B%22column%22:0,%22selector%22:%22eq%22,%22value%22:%222012%22%7D,%7B%22column%22:2,%22selector%22:%22eq%22,%22value%22:%22Police-civilian%20ratio%22%7D]&limit=10");
 
						
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
		//showDialogue("Testing");

		
		lvName = (ListView) findViewById(R.id.cities);		
		lvName.setAdapter(new ArrayAdapter<String>(PolicePresence.this,
				android.R.layout.simple_list_item_1, name));		
		lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {			
			@Override			
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {				// TODO Auto-generated method stub				
				Toast.makeText(getBaseContext(), name[position],  Toast.LENGTH_SHORT).show();			
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
				PolicePresence.this.finish();
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
