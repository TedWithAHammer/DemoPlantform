package com.leo.demoplantform.service;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;

import com.leo.demoplantform.base.Constants;
import com.leo.demoplantform.utils.LogUtil;

/**
 * Created by Leo on 2016/6/6.
 */
public class DemoIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public DemoIntentService(String name) {
        super(name);
    }

    public DemoIntentService() {
        super("com.leo.demoplantform.demointentservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String fromAct = intent.getStringExtra(Constants.INTENT_SERVICE_TAG);
        if (!TextUtils.isEmpty(fromAct)) {
            LogUtil.i("--------", "From Activity" + fromAct);
            excuteTask(fromAct);
        }
    }

    private void excuteTask(final String fromAct) {
        try {
            Thread.sleep(1000);
            LogUtil.i("--------", fromAct + " taask finished");
            taskFeedback(fromAct);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void taskFeedback(String msg) {
        Intent intent = new Intent();
        intent.setAction(Constants.INTENT_SERVICE_BROADCAST);
        intent.putExtra(Constants.INTENT_SERVICE_FEED_BACK,msg);
        sendBroadcast(intent);
    }
}
