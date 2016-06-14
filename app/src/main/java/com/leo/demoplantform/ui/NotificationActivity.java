package com.leo.demoplantform.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
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
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    void sendDefaultNotificationBuilder(View v) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentInfo("content info");
        builder.setContentText("content text");
        builder.setContentTitle("content title");
        //time
        builder.setWhen(System.currentTimeMillis());
        //default light,sound,vibrate
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        //large icon
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon_big));
        //small icon
        builder.setSmallIcon(R.drawable.notification_icon_small);
        //pending intent
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, count++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(count, builder.build());
    }

    void sendPatialNotificationBuilder(View v) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentInfo("content info");
        builder.setContentText("content text");
        builder.setContentTitle("content title");
        builder.setWhen(System.currentTimeMillis());
        //light
        builder.setDefaults(Notification.DEFAULT_LIGHTS);
        //vibrate
        long[] vibrate = new long[]{
                5000, 2000
        };
        builder.setVibrate(vibrate);
        //sound
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon_big));
        builder.setSmallIcon(R.drawable.notification_icon_small);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, count++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(count, builder.build());
    }

    void sendRemoteViewNotificationBuilder(View v) {
        RemoteViews rv = new RemoteViews(this.getPackageName(), R.layout.notification_remote_view);
        rv.setCharSequence(R.id.tvContent, "setText", "dynamic inflate");
        rv.setImageViewResource(R.id.bigIcon, R.drawable.notification_icon_small);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContent(rv);
        //small icon necessary only set notification can be show
        builder.setSmallIcon(R.drawable.notification_icon_small);
        builder.setAutoCancel(true);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, count++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(count, builder.build());
    }
}
