package com.example.vm10.dominandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public final static String TITLE_ARG = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            if(!(this instanceof MainActivity)) actionBar.setDisplayHomeAsUpEnabled(true);

            String title = intent.getStringExtra(TITLE_ARG);
            if(title != null)
                actionBar.setTitle(title);
        }
    }
}
