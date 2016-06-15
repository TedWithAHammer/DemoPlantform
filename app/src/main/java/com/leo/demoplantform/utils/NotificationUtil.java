package com.leo.demoplantform.utils;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.RemoteViews;

import com.leo.demoplantform.R;

/**
 * Created by Leo on 2016/6/14.
 */
public class NotificationUtil {
    public static int requestCode = 1 << 20;

    public static void sendDefaultNotificationBuilder(Context context, @NonNull String contentInfo, @NonNull String contentText, @NonNull String contentTitle,
                                                      long when, boolean autoCancel, int smallIconId, int largeIconId, Class<? extends Activity> clazz) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(autoCancel);
        builder.setContentInfo(TextUtils.isEmpty(contentInfo) ? "content info" : contentInfo);
        builder.setContentText(TextUtils.isEmpty(contentText) ? "content text" : contentText);
        builder.setContentTitle(TextUtils.isEmpty(contentTitle) ? "content title" : contentTitle);
        //time
        builder.setWhen(when > 0 ? when : System.currentTimeMillis());
        //default light,sound,vibrate
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        //large icon
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIconId > 0 ? largeIconId : R.drawable.notification_icon_big));
        //small icon
        builder.setSmallIcon(smallIconId > 0 ? smallIconId : R.drawable.notification_icon_small);
        //pending intent
        Intent intent = new Intent(context, clazz);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(requestCode, builder.build());
    }

    public static void sendPatialNotificationBuilder(Context context, @NonNull String contentInfo, @NonNull String contentText, @NonNull String contentTitle,
                                                     long when, boolean autoCancel, long[] vibrate, Uri soundUri,
                                                     int smallIconId, int largeIconId, Class<? extends Activity> clazz) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setAutoCancel(autoCancel);
        builder.setContentInfo(TextUtils.isEmpty(contentInfo) ? "content info" : contentInfo);
        builder.setContentText(TextUtils.isEmpty(contentText) ? "content text" : contentText);
        builder.setContentTitle(TextUtils.isEmpty(contentTitle) ? "content title" : contentTitle);
        //time
        builder.setWhen(when > 0 ? when : System.currentTimeMillis());
        //vibrate
        builder.setVibrate(vibrate);
        //sound
        builder.setSound(soundUri == null ? RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) : soundUri);
        //default light
        builder.setDefaults(Notification.DEFAULT_LIGHTS);
        //large icon
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIconId > 0 ? largeIconId : R.drawable.notification_icon_big));
        //small icon
        builder.setSmallIcon(smallIconId > 0 ? smallIconId : R.drawable.notification_icon_small);
        //pending intent
        Intent intent = new Intent(context, clazz);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(requestCode, builder.build());
    }

    public static void sendRemoteViewNotificationBuilder(Context context, @NonNull RemoteViews remoteViews,
                                                         long when, boolean autoCancel, long[] vibrate, Uri soundUri,
                                                         int smallIconId, Class<? extends Activity> clazz) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContent(remoteViews);
        builder.setWhen(when);
        builder.setVibrate(vibrate);
        builder.setSound(soundUri);
        //small icon necessary only set notification can be show
        builder.setSmallIcon(smallIconId);
        builder.setAutoCancel(autoCancel);
        Intent intent = new Intent(context, clazz);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode++, intent, 0);
        builder.setContentIntent(pendingIntent);
        nm.notify(requestCode, builder.build());
    }
}
