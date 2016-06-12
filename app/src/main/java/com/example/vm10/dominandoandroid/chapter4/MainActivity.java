package com.example.vm10.dominandoandroid.chapter4;

import com.example.vm10.dominandoandroid.BaseMainActivity;
import java.util.Map;

public class MainActivity extends BaseMainActivity {

    @Override
    protected void loadActionsMap(Map<String, Class<?>> actionsMap) {
        actionsMap.put("TextView", com.example.vm10.dominandoandroid.chapter4.TextViewActivity.class);
        actionsMap.put("EditText", com.example.vm10.dominandoandroid.chapter4.EditTextActivity.class);
        actionsMap.put("AutoCompleteTextView", com.example.vm10.dominandoandroid.chapter4.AutoCompleteTextViewActivity.class);
        actionsMap.put("Adapter", com.example.vm10.dominandoandroid.chapter4.AdapterActivity.class);
        actionsMap.put("ExpandableListView", com.example.vm10.dominandoandroid.chapter4.ExpandableListViewActivity.class);
    }
}
