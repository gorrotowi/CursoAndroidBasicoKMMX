package kmmx.dinamicfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ItemPersona[] personas = {
            new ItemPersona("Elliot", "5530293010", "elliot@ecorp.com", "@elliotecorp"),
            new ItemPersona("Sebastian", "5530293010", "sebastian@ecorp.com", "@elliotecorp"),
            new ItemPersona("Raul", "5530293010", "raul@ecorp.com", "@elliotecorp"),
            new ItemPersona("Juan", "5530293010", "juan@ecorp.com", "@elliotecorp"),
            new ItemPersona("Melisa", "5530293010", "melisa@ecorp.com", "@elliotecorp"),
            new ItemPersona("Alberto", "5530293010", "alberto@ecorp.com", "@elliotecorp"),
            new ItemPersona("Diana", "5530293010", "diana@ecorp.com", "@elliotecorp"),
            new ItemPersona("Jorge", "5530293010", "jorge@ecorp.com", "@elliotecorp"),
            new ItemPersona("Paco", "5530293010", "paco@ecorp.com", "@elliotecorp"),
            new ItemPersona("Pepe", "5530293010", "pepe@ecorp.com", "@elliotecorp")
    };

    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listFragment);
        adapter = new ListAdapter(this, R.layout.item_persona, personas);

        listView.setAdapter(adapter);

        Log.e("Main", "onCreate: " + listView.getAdapter().getCount());

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            ItemPersona persona = (ItemPersona) listView.getAdapter().getItem(position);
            TextView txtDetail = (TextView) findViewById(R.id.txtDetalle);
            String detail = "Nombre: " + persona.getNombre() + "\n"
                    + "Correo: " + persona.getCorreo() + "\n"
                    + "Telefono: " + persona.getTelefono() + "\n"
                    + "Username: " + persona.getUsername();
            txtDetail.setText(detail);
        });

    }
}
