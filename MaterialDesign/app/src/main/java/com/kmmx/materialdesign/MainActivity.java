package com.kmmx.materialdesign;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.clans.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    FloatingActionButton fabSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fabSend = (FloatingActionButton) findViewById(R.id.fabSend);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        setSupportActionBar(toolbar);

        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorAccent));

        fabSend.setMax(100);
        fabSend.setIndeterminate(false);
        fabSend.setProgress(70, true);
    }
}
