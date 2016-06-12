package com.example.vm10.dominandoandroid;

import android.app.Application;
import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by VM10 on 22/05/2016.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
