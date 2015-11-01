package app.rockkworld.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import app.rockkworld.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends ActionBarActivity {


    @Bind(R.id.et_username)
    EditText et_userName;
    @Bind(R.id.et_password)
    EditText et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_forgetPassword).setClickable(true);
    }

    @OnClick(R.id.btn_signIn)
    public void onSignInClick() {

    }

    @OnClick(R.id.btn_signUp)
    public void onSignUpClick() {

    }

    @OnClick(R.id.btn_forgetPassword)
    public void onForgetPasswordClick() {

    }

}
