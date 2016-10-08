package com.kmmx.menustoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Toolbar toolbarCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle("Hola toolbar");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarCard.inflateMenu(R.menu.menu_toolbar_card);
        toolbarCard.setTitle("Toolbar Card");
        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemCard:
                        Toast.makeText(MainActivity.this, "Item Card", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Home Button", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Opcion " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.SubSubopcion1:
                Toast.makeText(this, "Opcion " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, MainActivity.class));
//        super.onBackPressed();
    }
}
