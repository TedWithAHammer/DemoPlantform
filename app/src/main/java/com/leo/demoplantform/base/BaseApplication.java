package com.leo.demoplantform.base;

import android.app.Application;

import com.leo.demoplantform.utils.LogUtil;

/**
 * Created by Leo on 2016/6/13.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setLogEnable(true);
    }
}
