package com.kmmx.consumows;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCompany extends AppCompatActivity {


    private static final String TAG = DetailCompany.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtCompanyName)
    TextView txtCompanyName;
    @BindView(R.id.txtServicioName)
    TextView txtServicioName;
    @BindView(R.id.txtCountry)
    TextView txtCountry;
    @BindView(R.id.txtLocation)
    TextView txtLocation;
    @BindView(R.id.txtNumStations)
    TextView txtNumStations;
    @BindView(R.id.activity_detail_company)
    LinearLayout activityDetailCompany;

    String companyurl;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_company);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle bundle = getIntent().getExtras();
        companyurl = bundle.getString("urlcompany");

        requestQueue = Volley.newRequestQueue(this);

        getComanyInfo();

    }

    private void getComanyInfo() {
        JsonObjectRequest jsonCompany = new JsonObjectRequest(Request.Method.GET, companyurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    parseJson(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(DetailCompany.this, "Algo salio mal, intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onErrorResponse: " + error.getNetworkTimeMs());
                final Snackbar snackbar =
                        Snackbar.make(activityDetailCompany, "Algo salio mal", Snackbar.LENGTH_INDEFINITE);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                        getComanyInfo();
                    }
                };
                snackbar.setAction("Reintentar", onClickListener);
                snackbar.show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("nombre", "androidapp");
                return headers;
            }
        };

        jsonCompany.setRetryPolicy(new DefaultRetryPolicy(1200, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(jsonCompany);
    }

    private void parseJson(JSONObject response) throws JSONException {
        JSONObject network = response.getJSONObject("network");
        JSONArray companynames = network.getJSONArray("company");
        JSONObject location = network.getJSONObject("location");
        JSONArray stations = network.getJSONArray("stations");
        String nombre = network.getString("name");
        String ciudad = location.getString("city");
        String pais = location.getString("country");
        double latitude = location.getDouble("latitude");
        double longitude = location.getDouble("longitude");

        for (int i = 0; i < stations.length(); i++) {
            JSONObject jsonestacion = stations.getJSONObject(i);

        }

        txtCompanyName.setText(companynames.get(0).toString());
        txtServicioName.setText(nombre);
        txtCountry.setText(pais + " " + ciudad);
        txtLocation.setText("Lat: " + latitude + " Long: " + longitude);
        txtNumStations.setText(stations.length() + "");

    }
}
