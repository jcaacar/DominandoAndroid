package com.example.vm10.dominandoandroid.chapter2;

import com.example.vm10.dominandoandroid.BaseMainActivity;
import java.util.Map;

public class MainActivity extends BaseMainActivity {

    @Override
    protected void loadActionsMap(Map<String, Class<?>> actionsMap) {
        actionsMap.put("Parcelable", SenderParcelableActivity.class);
    }
}
