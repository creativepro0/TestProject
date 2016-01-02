package app.rockkworld;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import app.rockkworld.utils.PrefUtils;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by rohit on 31/10/15.
 */
public class RockkWorldApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrefUtils.init(getApplicationContext());
        initUIL();
        initVolley();
    }

    private void initVolley() {
        VolleyManager.init(getApplicationContext());
    }

    private void initUIL() {
        ImageLoader instance = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .denyCacheImageMultipleSizesInMemory()
                .memoryCacheSizePercentage(40)
                .build();
        instance.init(configuration);
    }
}
