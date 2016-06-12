package com.example.vm10.dominandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public abstract class BaseMainActivity extends BaseActivity {

    @BindView(R.id.lvActions)
    ListViewCompat lvActions;

    private Map<String, Class<?>> actionsMap = new LinkedHashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_main);
        ButterKnife.bind(this);

        loadActionsMap(actionsMap);

        Object[] keys = actionsMap.keySet().toArray();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_list_item, keys);
        lvActions.setAdapter(adapter);
    }

    @OnItemClick(R.id.lvActions)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String key = (String)lvActions.getItemAtPosition(position);
        Class<?> clazz = actionsMap.get(key);
        Intent intent = new Intent(this, clazz);
        intent.putExtra(BaseActivity.TITLE_ARG, key);
        startActivity(intent);
    }

    protected abstract void loadActionsMap(Map<String, Class<?>> actionsMap);
}
