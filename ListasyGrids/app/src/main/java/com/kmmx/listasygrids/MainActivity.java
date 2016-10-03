package com.kmmx.listasygrids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
//    GridView gridView;

    String[] datos = new String[]{
            "Apple", "Google", "Microsoft", "Paypal", "Tesla", "Virgin", "Twitter", "Facebook"
    };

    AdapterProfile adapterProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
//        gridView = (GridView) findViewById(R.id.gridView);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datos);
//        gridView.setAdapter(adapter);
//        listView.setAdapter(adapter);

        adapterProfile = new AdapterProfile(this, R.layout.item_list, getData());
        listView.setAdapter(adapterProfile);

    }

    private ArrayList<ItemList> getData() {
        ArrayList<ItemList> item = new ArrayList<>();
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Desarrolador", R.mipmap.ic_launcher));
        return item;
    }

    @Override
    protected void onResume() {
        super.onResume();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView textView = (TextView) view.findViewById(android.R.id.text1);
//                Toast.makeText(MainActivity.this, "Posicion: " + position + "\nNombre: " + textView.getText().toString(), Toast.LENGTH_SHORT).show();
                TextView textViewTitle = (TextView) view.findViewById(R.id.txtItemTitle);
                TextView textViewSubTile = (TextView) view.findViewById(R.id.txtItemSubTitle);
                String name = textViewTitle.getText().toString() + "\n" + textViewSubTile.getText().toString();
                Toast.makeText(MainActivity.this, "Posicion: " + position + "\n" + name, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "LongClick", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView textView = (TextView) view.findViewById(android.R.id.text1);
//                Toast.makeText(MainActivity.this, "Posicion: " + position + "\nNombre: " + textView.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
