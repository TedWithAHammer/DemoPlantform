package com.leo.demoplantform.utils;

import android.util.Log;

/**
 * Created by Leo on 2016/6/13.
 */
public class LogUtil {
    public static boolean LOG_ENABLE = true;

    public static void setLogEnable(boolean logEnable) {
        LOG_ENABLE = logEnable;
    }

    public static int i(String tag, String content) {
        if (LOG_ENABLE) {
            return Log.i(tag, content);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String content) {
        if (LOG_ENABLE) {
            return Log.e(tag, content);
        } else {
            return 0;
        }
    }

    public static int w(String tag, String content) {
        if (LOG_ENABLE) {
            return Log.w(tag, content);
        } else {
            return 0;
        }
    }
    public static int d(String tag, String content) {
        if (LOG_ENABLE) {
            return Log.d(tag, content);
        } else {
            return 0;
        }
    }
    public static int v(String tag, String content) {
        if (LOG_ENABLE) {
            return Log.v(tag, content);
        } else {
            return 0;
        }
    }
}
