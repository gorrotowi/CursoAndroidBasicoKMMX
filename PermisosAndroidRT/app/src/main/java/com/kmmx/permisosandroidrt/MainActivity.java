package com.kmmx.permisosandroidrt;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnReadSms;
    TextView txtSms;
    int REQUEST_CODE_SMS = 1;
    String[] permisos = {Manifest.permission.READ_SMS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReadSms = (Button) findViewById(R.id.btnReadSms);
        txtSms = (TextView) findViewById(R.id.txtSms);

        BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            txtSms.append("porcentaje de bateria " + batLevel + "\n\n\n");
        }

        checkReadSMSPermission();

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnReadSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReadSMSPermission();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readSMS();
            } else {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Permisos invalidos")
                        .setMessage("No se pueden leer los mensajes, por favor acepta el permiso de lectura")
                        .setPositiveButton("Autorizar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                checkReadSMSPermission();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        }

    }

    private void checkReadSMSPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permisos, REQUEST_CODE_SMS);
            } else {
                readSMS();
            }
        } else {
            readSMS();
        }
    }


    private void readSMS() {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor.moveToFirst()) {
            //TODO
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                String columName = cursor.getColumnName(i);
                Log.e(TAG, "readSMS: " + columName);
            }

            for (int i = 0; i < cursor.getCount(); i++) {
                String address = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                String smstxt = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                txtSms.append("\n" + address + "\n" + smstxt + "\n");
                cursor.moveToNext();
            }
        } else {
            cursor.close();
        }
    }
}
