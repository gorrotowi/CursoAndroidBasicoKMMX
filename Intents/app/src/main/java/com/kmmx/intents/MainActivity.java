package com.kmmx.intents;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends BaseActivity {

    Toolbar toolbar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button button = (Button) findViewById(R.id.btnMain);
        Button buttonP = (Button) findViewById(R.id.btnProgressMain);

        progressBar = new ProgressBar(this);

        addContentView(progressBar, new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        hideProgress(progressBar);

        setUpToolbar(toolbar, getString(R.string.app_name), R.mipmap.ic_launcher);

        button.setOnClickListener(v -> {
//            showToast("Hola lambda");
            showToast(R.string.app_name);
            showProgress(progressBar);
        });

        buttonP.setOnClickListener(v -> {
            hideProgress(progressBar);
            goView(SeconActivity.class);
        });

    }
}
