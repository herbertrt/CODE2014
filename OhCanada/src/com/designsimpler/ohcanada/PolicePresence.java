package com.designsimpler.ohcanada;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.io.*;
import java.net.*;
import org.json.*;

public class PolicePresence extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_police_presence);
		
		/*try {
            // Build Connection
            URL api_url = new URL("http://www.earthquakescanada.nrcan.gc.ca/api/earthquakes/");
            URLConnection api = api_url.openConnection();

            // Set HTTP Headers
            api.setRequestProperty("Accept", "application/json");
            api.setRequestProperty("Accept-Language", "en");

            // Get Response
            JSONTokener tokener = new JSONTokener(api.getInputStream());
            JSONObject jsondata = new JSONObject(tokener);

            // Display API name
            System.out.println(jsondata.getJSONObject("metadata")
                                       .getJSONObject("request")
                                       .getJSONObject("name")
                                       .get("en").toString());

            // Iterate over latest links
            JSONObject latest = jsondata.getJSONObject("latest");
            for (Object item : latest.keySet()) {
                System.out.println(item.toString() + " -> " + latest.get(item.toString()));
            }

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL");
        } catch (IOException e) {
            System.out.println("IO Error");
        }*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.police_presence, menu);
		return true;
	}

}
