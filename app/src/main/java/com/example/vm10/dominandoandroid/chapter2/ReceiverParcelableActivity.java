package com.example.vm10.dominandoandroid.chapter2;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vm10.dominandoandroid.BaseActivity;
import com.example.vm10.dominandoandroid.model.Person;

public class ReceiverParcelableActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Person p =  getIntent().getParcelableExtra(SenderParcelableActivity.PERSON);

        if(p != null) {
            TextView txtView = new AppCompatTextView(this);
            txtView.setText(p.toString());

            RelativeLayout.LayoutParams lpTxtView = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lpTxtView.addRule(RelativeLayout.CENTER_IN_PARENT);
            txtView.setLayoutParams(lpTxtView);

            RelativeLayout root = new RelativeLayout(this);
            root.addView(txtView);

            setContentView(root, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        }
    }
}
