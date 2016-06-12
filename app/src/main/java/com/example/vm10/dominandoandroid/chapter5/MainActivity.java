package com.example.vm10.dominandoandroid.chapter5;

import com.example.vm10.dominandoandroid.BaseMainActivity;
import java.util.Map;

public class MainActivity extends BaseMainActivity {

    @Override
    protected void loadActionsMap(Map<String, Class<?>> actionsMap) {
        actionsMap.put("CustomView", com.example.vm10.dominandoandroid.chapter5.CustomViewActivity.class);
    }
}
