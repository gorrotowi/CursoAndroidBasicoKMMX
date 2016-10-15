package com.kmmx.fragmentosbasicos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMain;
    Fragment fragmentuno, fragmentdos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.btnMainActivity);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hola!", Toast.LENGTH_SHORT).show();
            }
        });

        if (findViewById(R.id.fragmentdos) == null) {
            Toast.makeText(this, "No hat fragment dos, esto es un telefono", Toast.LENGTH_SHORT).show();
        }

    }
}
