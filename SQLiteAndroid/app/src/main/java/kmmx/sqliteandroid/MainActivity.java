package kmmx.sqliteandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DBController dbController;

    TextView txtContent;
    EditText edtxName, edtxAddress, edtxAge;
    Button btnInsert, btnDelete;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbController = new DBController(MainActivity.this);

        txtContent = (TextView) findViewById(R.id.txtContenido);
        edtxName = (EditText) findViewById(R.id.edtxName);
        edtxAddress = (EditText) findViewById(R.id.edtxAddress);
        edtxAge = (EditText) findViewById(R.id.edtxAge);
        btnInsert = (Button) findViewById(R.id.btnInsertar);
        btnDelete = (Button) findViewById(R.id.btnBorrar);

        dbController.open();
        showData();
        dbController.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbController.open();
                try {
                    dbController.insertData(edtxName.getText().toString(), edtxAddress.getText().toString(), Integer.parseInt(edtxAge.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                showData();
                dbController.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                dbController.open();
                dbController.delete(index);
                showData();
                dbController.close();
            }
        });
    }

    private void showData() {
        txtContent.setText(null);
        Cursor cursor = dbController.getData();

        if (cursor.moveToFirst()) {
            do {
                int nameIndx = cursor.getColumnIndex("nombre");
                int addressIndx = cursor.getColumnIndex("domicilio");
                int ageIndx = cursor.getColumnIndex("edad");
                String name = cursor.getString(nameIndx);
                int age = cursor.getInt(ageIndx);
                String address = cursor.getString(addressIndx);
                Log.e("DB", "showData: " + cursor.getInt(cursor.getColumnIndex(DBHelper._ID)));
                txtContent.append("nombre: " + name + " direccion: " + address + " Edad: " + age + "\n");
            } while (cursor.moveToNext());
        }

    }
}
