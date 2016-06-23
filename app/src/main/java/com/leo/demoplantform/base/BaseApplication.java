package com.leo.demoplantform.base;

import android.app.Application;

import com.leo.demoplantform.utils.LogUtil;

/**
 * Created by Leo on 2016/6/13.
 */
public class BaseApplication extends Application {
    private final String LOG_TAG = "com.leo.demoplantform";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(LOG_TAG,true);

    }
}
