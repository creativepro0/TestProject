package app.rockkworld.com.mproject.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import app.rockkworld.R;

public class SignUpActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_signIn).setOnClickListener(this);
        findViewById(R.id.btn_signUp).setOnClickListener(this);
        findViewById(R.id.btn_forgetPassword).setOnClickListener(this);
        findViewById(R.id.btn_forgetPassword).setClickable(true);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_signIn:
                break;
            case R.id.btn_forgetPassword:
                break;
            case R.id.btn_signUp:
                break;
        }

    }
}
