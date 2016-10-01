package com.kmmx.holamundo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView textViewName;
    CheckBox checkboxBienvenida;
    RadioGroup radioGroup;
    RadioButton rdbtnNaranja, rdbtnManzana, rdbtnPlatano;
    private String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = (TextView) findViewById(R.id.txtBienvenidaName);
        checkboxBienvenida = (CheckBox) findViewById(R.id.checkboxBienvenida);
        radioGroup = (RadioGroup) findViewById(R.id.rdGroupBienvenida);
        rdbtnNaranja = (RadioButton) findViewById(R.id.rdbtnNaranja);
        rdbtnManzana = (RadioButton) findViewById(R.id.rdbtnManzana);
        rdbtnPlatano = (RadioButton) findViewById(R.id.rdbtnPlatano);

        Bundle params = getIntent().getExtras();
        String name = params.getString(getString(R.string.intent_name), "default");
        textViewName.setText(name);

        Log.e("MSG Name", name);
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkboxBienvenida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "onCheckedChanged: " + isChecked);
                if (isChecked) {
                    new AlertDialog.Builder(SecondActivity.this)
                            .setTitle("Terminos y condiciones")
                            .setMessage("Estas seguro de que quieres vender tu alma?")
                            .setPositiveButton("Si, estoy seguro", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(SecondActivity.this, "Gracias por tu alma", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("No, gracias", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(SecondActivity.this, "Seguro?", Toast.LENGTH_SHORT).show();
                                    checkboxBienvenida.setChecked(false);
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbtnNaranja:
                        Log.e(TAG, "onCheckedChanged: Naranja ");
                        break;
                    case R.id.rdbtnManzana:
                        Log.e(TAG, "onCheckedChanged: Manzana ");
                        break;
                    case R.id.rdbtnPlatano:
                        Log.e(TAG, "onCheckedChanged: Platano ");
                        break;
                }
            }
        });

        rdbtnManzana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(SecondActivity.this, "Manzana seleccionada", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
