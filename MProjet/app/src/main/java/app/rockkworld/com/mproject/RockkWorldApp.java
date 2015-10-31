package app.rockkworld.com.mproject;

import android.app.Application;

import app.rockkworld.com.mproject.utils.PrefUtils;

/**
 * Created by rohit on 31/10/15.
 */
public class RockkWorldApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrefUtils.init(getApplicationContext());
    }
}
