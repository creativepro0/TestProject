package app.rockkworld.com.mproject.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import app.rockkworld.R;
import app.rockkworld.com.mproject.utils.PrefUtils;


public class RSplashActivity extends Activity {


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = null;
            if (PrefUtils.get().isLoggedIn()) {
                intent = new Intent(RSplashActivity.this, WallActivity.class);
            } else {
                intent = new Intent(RSplashActivity.this, SignUpActivity.class);
            }
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsplash);
    }


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().getDecorView().postDelayed(runnable, 3000);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getWindow().getDecorView().removeCallbacks(runnable);
    }

}
