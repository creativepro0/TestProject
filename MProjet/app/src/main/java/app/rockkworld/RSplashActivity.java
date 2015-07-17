package app.rockkworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;

import app.rockkworld.R;


public class RSplashActivity extends Activity {


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(RSplashActivity.this, SignUpActivity.class);
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
