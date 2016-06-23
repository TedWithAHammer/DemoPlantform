package com.leo.demoplantform.ui.eventBus;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.demoplantform.bean.MessageBody;
import com.leo.potato.PotatoInjection;

import org.greenrobot.eventbus.EventBus;

public class EventBusActivity1 extends BaseActivity {
    @PotatoInjection(idStr = "textContent")
    EditText textContent;
    @PotatoInjection(idStr = "btnSendMainThread", click = "sendMessageMainThread")
    Button btnSendMainThread;
    @PotatoInjection(idStr = "btnSendWorkThread", click = "sendMessageWorkThread")
    Button btnSendWorkThread;
    @PotatoInjection(idStr = "btnStartOtherActivity", click = "startOtherActivity")
    Button btnStartOtherActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus1);

    }

    /**
     * 主线程发送消息
     *
     * @param v
     */
    private void sendMessageMainThread(View v) {
        if (!TextUtils.isEmpty(textContent.getText().toString())) {
            EventBus.getDefault().post(new MessageBody(textContent.getText().toString()));
        }
    }

    /**
     * 子线程发送消息
     *
     * @param v
     */
    private void sendMessageWorkThread(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(textContent.getText().toString())) {
                    EventBus.getDefault().post(new MessageBody(textContent.getText().toString()));
                }
            }
        }).start();
    }

    private void startOtherActivity(View v) {
        startActivity(new Intent(this, EventBusActivity2.class));
    }
}
