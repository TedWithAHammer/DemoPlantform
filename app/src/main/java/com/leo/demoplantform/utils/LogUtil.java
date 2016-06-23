package com.leo.demoplantform.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * Created by Leo on 2016/6/13.
 */
public class LogUtil {
    public static boolean LOG_ENABLE = true;
    public static String Tag = "----------";

    public static void init(String tag, boolean logEnable) {
        if (!TextUtils.isEmpty(Tag)) {
            Tag = tag;
            Logger.init(Tag);
            LOG_ENABLE = logEnable;
        } else {
            Logger.init();
            LOG_ENABLE = logEnable;
        }
    }

    public static void setLogEnable(boolean logEnable) {
        LOG_ENABLE = logEnable;
    }

    public static void i(@Nullable String tag, String content) {
        if (LOG_ENABLE) {
            if (TextUtils.isEmpty(tag))
                Logger.i(Tag, content);
            else
                Logger.i(tag, content);

        }
    }

    public static void e(@Nullable String tag, String content) {
        if (LOG_ENABLE) {
            if (TextUtils.isEmpty(tag))
                Logger.e(Tag, content);
            else
                Logger.e(tag, content);
        }
    }

    public static void w(@Nullable String tag, String content) {
        if (LOG_ENABLE) {
            if (TextUtils.isEmpty(tag))
                Logger.w(Tag, content);
            else
                Logger.w(tag, content);
        }
    }

    public static void d(@Nullable String tag, String content) {
        if (LOG_ENABLE) {
            if (TextUtils.isEmpty(tag))
                Logger.d(Tag, content);
            else
                Logger.d(tag, content);
        }
    }

    public static void v(@Nullable String tag, String content) {
        if (LOG_ENABLE) {
            if (TextUtils.isEmpty(tag))
                Logger.v(Tag, content);
            else
                Logger.v(tag, content);
        }
    }

    public static void i(String content) {
        if (LOG_ENABLE) {
            Logger.i(Tag, content);

        }
    }

    public static void e(String content) {
        if (LOG_ENABLE) {
            Logger.e(Tag, content);
        }
    }

    public static void w(String content) {
        if (LOG_ENABLE) {
            Logger.w(Tag, content);
        }
    }

    public static void d(String content) {
        if (LOG_ENABLE) {
            Logger.d(Tag, content);
        }
    }

    public static void v(String content) {
        if (LOG_ENABLE) {
            Logger.v(Tag, content);
        }
    }
}
