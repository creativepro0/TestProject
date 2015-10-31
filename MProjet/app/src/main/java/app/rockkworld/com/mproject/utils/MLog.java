package app.rockkworld.com.mproject.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by divya on 17/7/15.
 */
public class MLog {

    public static final String APP_TAG = "Rockkworld";

    public static void d(String message) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.d(APP_TAG, message);

    }

    public static void d(String tag, String message) {


        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.d(tag, message);

    }

    public static void e(String message) {


        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.e(APP_TAG, message);

    }

    public static void e(String tag, String message) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.e(tag, message);

    }

    public static void i(String tag, String message) {


        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.i(tag, message);

    }

    public static void v(String tag, String message) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.v(tag, message);
    }

    public static void w(String tag, String message) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.w(tag, message);
    }

    public static void wtf(String tag, String message) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.wtf(tag, message);
    }


    public static void printMap(Hashtable<String, ?> map) {
        printMap(APP_TAG, map);
    }

    public static void printMap(String tag, Hashtable<String, ?> map) {

        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Enumeration<String> keys = map.keys();
        Log.d(tag, "[");
        while (keys.hasMoreElements()) {
            String s = keys.nextElement();
            Log.d(tag, "key: " + s + " = " + map.get(s).toString());
        }
        Log.d(tag, "]");
    }


    public static void printArrList(ArrayList arrayList) {
        printArrList(APP_TAG, arrayList);
    }

    public static void printArrList(String tag, ArrayList arrayList) {
        if (Config.ENVIRONMENT == Config.LIVE_ENVIROMENT) {
            return;
        }
        Log.d(tag, "{");
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d(tag, "[ " + i + "] : " + arrayList.get(i));
        }
        Log.d(tag, "}");
    }

}
