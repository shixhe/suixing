package com.smartlink.suixing;

import android.app.Application;

/**
 * Created by wuxiaojun on 2018/8/26.
 */

public class App extends Application {

    public static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static App getAppContext() {
        return mApp;
    }

}
