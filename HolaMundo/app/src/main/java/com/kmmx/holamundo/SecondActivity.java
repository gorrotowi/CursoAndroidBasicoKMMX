package com.kmmx.holamundo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = (TextView) findViewById(R.id.txtBienvenidaName);

        Bundle params = getIntent().getExtras();
        String name = params.getString(getString(R.string.intent_name), "default");
        textViewName.setText(name);

        Log.e("MSG Name", name);
    }
}
