package com.leo.demoplantform.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.leo.demoplantform.utils.LogUtil;

/**
 * Created by Leo on 2016/6/3.
 */
public class DemoService extends Service {


    public class MyBinder extends Binder {
        public DemoService getService() {
            return DemoService.this;
        }
    }

    MyBinder binder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.i("--------", "onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        LogUtil.i("--------", "onCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        LogUtil.i("--------", "onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.i("--------", "onStartCommand" + intent == null ? "null intent" : "not null intent");
        return Service.START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.i("--------", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        LogUtil.i("--------", "onDestroy");
        super.onDestroy();
    }

}
