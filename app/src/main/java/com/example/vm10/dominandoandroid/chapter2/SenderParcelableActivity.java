package com.example.vm10.dominandoandroid.chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vm10.dominandoandroid.BaseActivity;
import com.example.vm10.dominandoandroid.R;
import com.example.vm10.dominandoandroid.model.Person;

import org.joda.time.DateTime;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SenderParcelableActivity extends BaseActivity {

    public static final String PERSON = SenderParcelableActivity.class.getSimpleName();
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_sender);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSend)
    public void sendPerson(View view) {
        person = new Person(1, "Zeca", new DateTime(1987, 10, 10, 0, 0));
        Intent intent = new Intent(this, ReceiverParcelableActivity.class);
        intent.putExtra(PERSON, person);
        intent.putExtra(BaseActivity.TITLE_ARG, getIntent().getStringExtra(BaseActivity.TITLE_ARG));
        startActivity(intent);
    }
}
