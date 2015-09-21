package app.rockkworld.com.mproject.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import app.rockkworld.R;


public class RSplashActivity extends Activity {


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            Intent intent = new Intent(RSplashActivity.this, SignUpActivity.class);
            Intent intent = new Intent(RSplashActivity.this, WallActivity.class);
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

    public void startTransition(View v){

//
//        Intent intent=new Intent(this,WallActivity.class);
//        switch (v.getId()){
//            case R.id.img1:
//                intent.putExtra("color",1);
//                break;
//            case R.id.img2:
//                intent.putExtra("color",2);
//                break;
//            case R.id.img3:
//                intent.putExtra("color",3);
//                break;
//        }
//
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
//            String transitionName = getString(R.string.title_activity_wall);
//            ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, v, transitionName);
//            startActivity(intent, transitionActivityOptions.toBundle());
//        }else {
//            startActivity(intent);
//        }
    }
}
