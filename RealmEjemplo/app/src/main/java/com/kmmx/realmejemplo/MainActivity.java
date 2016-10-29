package com.kmmx.realmejemplo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText edtxtName, edtxtAddress, edtxtEdad;
    TextView txtcontent;

    Usuario usuario;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtxtName = (EditText) findViewById(R.id.edtxName);
        edtxtAddress = (EditText) findViewById(R.id.edtxAddress);
        edtxtEdad = (EditText) findViewById(R.id.edtxEdad);
        txtcontent = (TextView) findViewById(R.id.content_users);

        realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        usuario = new Usuario();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.nombre = edtxtName.getText().toString();
                usuario.direccion = edtxtAddress.getText().toString();
                try {
                    usuario.edad = Integer.parseInt(edtxtEdad.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    usuario.edad = 0;
                }
                realm.beginTransaction();
                realm.copyToRealm(usuario);
                realm.commitTransaction();

                final RealmResults<Usuario> users = realm.where(Usuario.class)
                        .lessThan("edad", 22)
                        .findAll();
                Log.e(TAG, "users size: " + users.size());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        users.deleteAllFromRealm();
                        RealmResults<Usuario> users2 = realm.where(Usuario.class)
                                .findAll();
                        Log.e(TAG, "users size after delete: " + users2.size());
                        txtcontent.setText(null);
                        for (int i = 0; i < users2.size(); i++) {
                            txtcontent.append("Nombre: " + users2.get(i).nombre + " Direccion: " + users2.get(i).direccion + " Edad: " + users2.get(i).edad + "\n");
                        }
                    }
                });
            }
        });
    }

}
