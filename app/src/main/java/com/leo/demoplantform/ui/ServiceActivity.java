package com.leo.demoplantform.ui;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.demoplantform.base.Constants;
import com.leo.demoplantform.service.DemoIntentService;
import com.leo.demoplantform.service.DemoService;
import com.leo.potato.PotatoInjection;

public class ServiceActivity extends BaseActivity  {
    DemoService ls;
    @PotatoInjection(idStr = "btnBindService", click = "startBindService")
    private Button btnBindService;
    @PotatoInjection(idStr = "btnUnBindService", click = "startUnBindService")
    private Button btnUnBindService;
    @PotatoInjection(idStr = "btnStartService", click = "startService")
    private Button btnStartService;
    @PotatoInjection(idStr = "btnKillService", click = "killService")
    private Button btnKillService;
    @PotatoInjection(idStr = "btnStartIntentService", click = "startIntentService")
    private Button btnStartIntentService;
    @PotatoInjection(idStr = "tvServiceFeedback")
    private TextView tvServiceFeedback;


    private ServiceConnection sc;
    private DemoBroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        inflateView();
        initServiceConnection();
    }

    private void inflateView() {
        broadcastReceiver = new DemoBroadcastReceiver();
    }

    private void initServiceConnection() {
        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("--------", "onServiceConnected");
                ls = ((DemoService.MyBinder) service).getService();
                if (ls == null) {
                    return;
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("--------", "onServiceDisconnected");
                ls = null;
            }
        };
    }


    void startBindService(View v) {
        Intent intent = new Intent(this, DemoService.class);
        bindService(intent, sc, Service.BIND_AUTO_CREATE);
    }

    void startUnBindService(View v) {
        if (sc != null)
            unbindService(sc);
    }

    void startService(View v) {
        Intent intent = new Intent(this, DemoService.class);
        startService(intent);
    }

    void killService(View v) {
        Intent intent = new Intent(this, DemoService.class);
        stopService(intent);
    }

    int i = 0;

    void startIntentService(View v) {
        Intent intent = new Intent(this, DemoIntentService.class);
        intent.putExtra(Constants.INTENT_SERVICE_TAG, "activity" + i);
        startService(intent);
        i++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReceive();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterBroadcastReceive();
    }

    private void unregisterBroadcastReceive() {
        unregisterReceiver(broadcastReceiver);
    }

    private void registerBroadcastReceive() {
        IntentFilter intentFilter = new IntentFilter(Constants.INTENT_SERVICE_BROADCAST);
        registerReceiver(broadcastReceiver, intentFilter);
    }


    class DemoBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String feedBack = intent.getStringExtra(Constants.INTENT_SERVICE_FEED_BACK);
            if (!TextUtils.isEmpty(feedBack)) {
                tvServiceFeedback.setText(tvServiceFeedback.getText().toString()+"\n"+feedBack);
            }
        }
    }
}
