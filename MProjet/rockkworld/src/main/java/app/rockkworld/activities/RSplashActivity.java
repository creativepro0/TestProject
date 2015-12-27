package app.rockkworld.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import app.rockkworld.R;
import app.rockkworld.utils.PrefUtils;
//import app.rockkworld.utils.PrefUtils;


public class RSplashActivity extends Activity {


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = null;
            if (PrefUtils.get().isLoggedIn()) {
                intent = new Intent(RSplashActivity.this, RWActivity.class);
            } else {
                intent = new Intent(RSplashActivity.this, LoginSignUpActivity.class);
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
        getWindow().getDecorView().postDelayed(runnable, 1000);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getWindow().getDecorView().removeCallbacks(runnable);
    }

}
