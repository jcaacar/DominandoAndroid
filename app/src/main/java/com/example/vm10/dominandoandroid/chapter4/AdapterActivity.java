package com.example.vm10.dominandoandroid.chapter4;

import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;

import com.example.vm10.dominandoandroid.BaseActivity;
import com.example.vm10.dominandoandroid.R;
import com.example.vm10.dominandoandroid.model.Person;
import com.example.vm10.dominandoandroid.model.adapter.PersonAdapter;
import com.example.vm10.dominandoandroid.util.Util;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class AdapterActivity extends BaseActivity {

    @BindView(R.id.lvPersons)
    ListViewCompat lvPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        ButterKnife.bind(this);

        final List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Zeca", new DateTime(1987, 10, 10, 0, 0)));
        persons.add(new Person(2, "Jorge", new DateTime(1982, 02, 17, 0, 0)));
        persons.add(new Person(3, "Clarisse", new DateTime(1992, 10, 5, 0, 0)));
        persons.add(new Person(3, "Carsilla", new DateTime(1993, 4, 11, 0, 0)));

        final PersonAdapter pAdapter = new PersonAdapter(this, persons);
        lvPersons.setAdapter(pAdapter);
    }

    @OnItemClick(R.id.lvPersons)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person p = (Person) lvPersons.getItemAtPosition(position);
        Util.showDialog(this, "Person", p.toString());
    }
}
