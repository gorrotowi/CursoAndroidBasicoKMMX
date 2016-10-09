package com.kmmx.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textViewl;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnMain);
        editText = (EditText) findViewById(R.id.edtxMain);
        textViewl = (TextView) findViewById(R.id.txtMain);

        sharedPreferences = getSharedPreferences("nombres", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("nombre", getString(R.string.app_name));
        textViewl.setText(name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewl.setText(editText.getText().toString());
                editor = sharedPreferences.edit();
                editor.putString("nombre", editText.getText().toString());
                editor.apply();
            }
        });

    }
}
