package com.asiainfo.sample;

import android.app.Application;
import android.util.Log;
import com.qw.soul.permission.Permission;


public class SimpleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(SimpleApplication.class.getSimpleName(), "appInit");
        Permission.setDebug(true);
        //no necessary
//        Permission.init(this);
    }
}
