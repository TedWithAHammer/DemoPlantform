package com.leo.demoplantform.ui;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.demoplantform.utils.NotificationUtil;
import com.leo.potato.PotatoInjection;

public class NotificationActivity extends BaseActivity {
    @PotatoInjection(idStr = "btnDefaultNotification", click = "sendDefaultNotificationBuilder")
    private Button btnDefaultNotification;
    @PotatoInjection(idStr = "btnPatialCustomeNotification", click = "sendPatialNotificationBuilder")
    Button btnPatialCustomeNotification;
    @PotatoInjection(idStr = "btnRemoteViewsNotification", click = "sendRemoteViewNotificationBuilder")
    Button btnRemoteViewsNotification;

    private NotificationManager nm;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    void sendDefaultNotificationBuilder(View v) {
        NotificationUtil.sendDefaultNotificationBuilder(this, "content info", "content text", "content title",
                System.currentTimeMillis(), true, R.drawable.notification_icon_small, R.drawable.notification_icon_big, MainActivity.class);
    }

    void sendPatialNotificationBuilder(View v) {
        NotificationUtil.sendPatialNotificationBuilder(this, "content info", "content text", "content title",
                System.currentTimeMillis() + 10000, true, new long[]{1000, 1000, 1000}, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),
                R.drawable.notification_icon_small, R.drawable.notification_icon_big, MainActivity.class);
    }

    void sendRemoteViewNotificationBuilder(View v) {
        RemoteViews rv = new RemoteViews(this.getPackageName(), R.layout.notification_remote_view);
        rv.setCharSequence(R.id.tvContent, "setText", "dynamic inflate");
        rv.setImageViewResource(R.id.bigIcon, R.drawable.notification_icon_small);
        NotificationUtil.sendRemoteViewNotificationBuilder(this, rv, System.currentTimeMillis(),
                true, new long[]{500, 500, 500, 500, 500}, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),
                R.drawable.notification_icon_small, MainActivity.class);
    }
}
