package com.example.vm10.dominandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public final static String TITLE_ARG = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent != null && getSupportActionBar() != null) {
            String title = intent.getStringExtra(TITLE_ARG);
            if(title != null && !title.isEmpty())
                getSupportActionBar().setTitle(title);
        }
    }
}
