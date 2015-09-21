package app.rockkworld.com.mproject.utils;

import android.util.Log;

/**
 * Created by divya on 17/7/15.
 */
public class MLog {

    public static final String APP_TAG="Rockkworld";

    public static void d(String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.d(APP_TAG, message);
        }

    }
    public static void d(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.d(tag, message);
        }

    }

    public static void e(String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.e(APP_TAG, message);
        }

    }
    public static void e(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.e(tag, message);
        }

    }

    public static void i(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.i(tag, message);
        }

    }

    public static void v(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.v(tag, message);
        }
    }

    public static void w(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.w(tag, message);
        }
    }

    public static void wtf(String tag, String message) {

        if (Config.ENVIRONMENT == Config.TEST_ENVIROMENT) {
            Log.wtf(tag, message);
        }
    }


}
