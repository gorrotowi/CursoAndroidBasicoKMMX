package com.kmmx.holamundo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

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
                            .setNeutralButton("Quiero comer", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
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

        rdbtnPlatano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    new MaterialDialog.Builder(SecondActivity.this)
                            .title("Frutas")
                            .content("Te gustan los platanos?")
                            .positiveText("Si")
                            .negativeText("No")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    TextView txtViewDialog = dialog.getContentView();
                                    Toast.makeText(SecondActivity.this, txtViewDialog.getText().toString(), Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Toast.makeText(SecondActivity.this, "No no me gustan", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                }
            }
        });

        rdbtnNaranja.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    final MaterialDialog materialDialog = new MaterialDialog.Builder(SecondActivity.this)
                            .title("Te gusta jugar?")
                            .customView(R.layout.content_dalog, false)
                            .positiveText("Si")
                            .show();

                    Button btnDialog = (Button) materialDialog.findViewById(R.id.btnContentDialog);
                    btnDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TextView textView = (TextView) materialDialog.findViewById(R.id.txtContentDialog);
                            Toast.makeText(SecondActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

    }
}
