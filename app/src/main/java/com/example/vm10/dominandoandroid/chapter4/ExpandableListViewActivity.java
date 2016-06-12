package com.example.vm10.dominandoandroid.chapter4;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.vm10.dominandoandroid.BaseActivity;
import com.example.vm10.dominandoandroid.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListViewActivity extends BaseActivity {

    @BindView(R.id.elvFootballClubs)
    ExpandableListView elvFootballClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ButterKnife.bind(this);

        LinkedHashMap<String, List<String>> footballClubs = new LinkedHashMap();
        footballClubs.put("Pernambuco", new ArrayList<String>() { { add("Sport"); add("Santa Cruz"); add("Náutico"); add("Central"); } } );
        footballClubs.put("São Paulo", new ArrayList<String>() { { add("Corinthians"); add("São Paulo"); add("Palmeiras"); add("Santos"); } } );
        footballClubs.put("Rio de Janeiro", new ArrayList<String>() { { add("Flamengo"); add("Vasco"); add("Fluminense"); } } );

        final FootballClubGroupAdapter adapter = new FootballClubGroupAdapter(footballClubs);
        elvFootballClubs.setAdapter(adapter);

        for (int i = 0; i < footballClubs.size(); i++)
            elvFootballClubs.expandGroup(i);
    }
}
