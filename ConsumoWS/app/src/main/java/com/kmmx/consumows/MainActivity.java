package com.kmmx.consumows;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    String baseurl = "http://api.citybik.es";
    String networkurl = "/v2/networks";
    String companyUrl;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listviewEcobici);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final ArrayList<String> datalist = new ArrayList<>();
        final ArrayList<String> urlcompanys = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, baseurl + networkurl, new JSONObject(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG, "onResponse: " + response.toString());
                        try {
                            JSONArray networks = response.getJSONArray("networks");
                            for (int i = 0; i < networks.length(); i++) {
                                JSONObject jsonNetwork = networks.getJSONObject(i);
                                String name = jsonNetwork.getString("name");
                                String href = jsonNetwork.getString("href");
                                Log.e(TAG, "onResponse: " + name);
                                datalist.add(name);
                                urlcompanys.add(href);
                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, datalist);
                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: " + error);
                    }
                });

        requestQueue.add(jsonObjectRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO cachar el href de la compañia
                //enviar a una nueva vista
                //en la nueva vista desplegar la informacion basica de esa compañia en su json, location, stations, etc
                //plus el item de la segunda lista sea custom plus plus si usan recyclerview
            }
        });

    }
}
