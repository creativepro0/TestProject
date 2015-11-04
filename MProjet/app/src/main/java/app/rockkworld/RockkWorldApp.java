package app.rockkworld;

import android.app.Application;

import app.rockkworld.network.MVolleyManager;
import app.rockkworld.utils.PrefUtils;

/**
 * Created by rohit on 31/10/15.
 */
public class RockkWorldApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrefUtils.init(getApplicationContext());
        MVolleyManager.getInstance(getApplicationContext());
    }
}
