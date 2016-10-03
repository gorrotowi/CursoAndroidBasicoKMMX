package com.kmmx.listasygrids;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapterProfile recyclerAdapterProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.rcView);
        recyclerAdapterProfile = new RecyclerAdapterProfile(this, getData());
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAdapterProfile);

    }

    private List<ItemList> getData() {
        List<ItemList> item = new ArrayList<>();
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Lalo", "Chef", "http://lorempixel.com/400/200"));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Lalo", "Chef", "http://lorempixel.com/400/200"));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Lalo", "Chef", "http://lorempixel.com/400/200"));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Lalo", "Chef", "http://lorempixel.com/400/200"));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Lalo", "Chef", "http://lorempixel.com/400/200"));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.profileimage));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        return item;
    }
}
