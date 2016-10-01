package com.kmmx.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//} implements View.OnClickListener {

    Button btnMain;
    TextView txtMain;
    EditText edtxtMain, edtxtMainEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.btnMain);
        txtMain = (TextView) findViewById(R.id.txtMain);
        edtxtMain = (EditText) findViewById(R.id.edtxtMainName);
        edtxtMainEdad = (EditText) findViewById(R.id.edtxtMainEdad);

//        btnMain.setOnClickListener(this);

//        btnMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = edtxtMain.getText().toString();
//                txtMain.setText("Hola " + name);
//            }
//        });

    }

    public void sayHello(View v) {
        String name = edtxtMain.getText().toString();
        String edad = edtxtMainEdad.getText().toString();
//        txtMain.setText("Hola " + name);
        txtMain.setText(getString(R.string.sayhello, name, edad));
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(getString(R.string.intent_name), name);
        startActivity(intent);
    }


//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btnMain) {
//            String name = edtxtMain.getText().toString();
//            txtMain.setText("Hola " + name);
//        }
//    }
}
