package com.example.vm10.dominandoandroid;

import java.util.Map;

public class MainActivity extends BaseMainActivity {

    @Override
    protected void loadActionsMap(Map<String, Class<?>> actionsMap) {
        actionsMap.put("Chapter 2" , com.example.vm10.dominandoandroid.chapter2.MainActivity.class);
        actionsMap.put("Chapter 4" , com.example.vm10.dominandoandroid.chapter4.MainActivity.class);
        actionsMap.put("Chapter 5" , com.example.vm10.dominandoandroid.chapter5.MainActivity.class);
    }
}
