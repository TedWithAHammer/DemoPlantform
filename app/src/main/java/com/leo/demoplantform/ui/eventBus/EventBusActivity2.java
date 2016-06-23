package com.leo.demoplantform.ui.eventBus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.demoplantform.bean.MessageBody;
import com.leo.demoplantform.utils.LogUtil;
import com.leo.potato.PotatoInjection;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity2 extends BaseActivity {
    @PotatoInjection(idStr = "btnStartOtherActivity", click = "startOtherActivity")
    Button btnStartOtherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(MessageBody msg) {
        LogUtil.i("onEvent", msg.msg_body);
    }

    //    @Subscribe
//    public void onEventMainThread(MessageBody msg) {
//        LogUtil.i("onEventMainThread", msg.msg_body);
//    }
//
//    @Subscribe
//    public void onEventBackgroundThread(MessageBody msg) {
//        LogUtil.i("onEventBackgroundThread", msg.msg_body);
//    }
//
//    @Subscribe
//    public void onEventAsync(MessageBody msg) {
//        LogUtil.i("onEventAsync", msg.msg_body);
//    }
    void startOtherActivity(View v) {
        startActivity(new Intent(this, EventBusActivity1.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
