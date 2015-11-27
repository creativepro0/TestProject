package app.rockkworld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;

import app.rockkworld.R;
import app.rockkworld.activities.LoginSignUp;
import app.rockkworld.model.Login;
import app.rockkworld.network.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.volley.GsonRequest;
import app.rockkworld.volley.RWRequest;
import app.rockkworld.volley.ResponseListener;
import app.rockkworld.volley.VolleyManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements TextView.OnEditorActionListener, ResponseListener {

    @Bind(R.id.et_username)
    EditText usrNameET;
    @Bind(R.id.et_password)
    EditText passwordET;

    public static LoginFragment newInstance(Bundle args) {
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }


    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_GO) {

        }
        return false;
    }

    @OnClick(R.id.btn_signIn)
    public void signIn(Button button) {
        String usrName=usrNameET.getText().toString();
        String password=passwordET.getText().toString();
        if (TextUtils.isEmpty(usrName)||TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(),"UserName/Password can not be blank ",Toast.LENGTH_LONG);
            return;
        }
        MLog.d("userName= "+usrName+" password= "+password);
        HashMap<String,String> params=new HashMap<String,String>();
        params.put("email",usrName);
        params.put("Password",password);
        GsonRequest loginReq=new GsonRequest(APIs.URL_Login(),params,this,Login.class);
        VolleyManager.addToQueue(loginReq);
    }

    @OnClick(R.id.btn_signUp)
    public void signUp(Button button) {
        getActivity().onBackPressed();
//        ((LoginSignUp)getActivity()).loadRegisterFragment();

    }

    @OnClick(R.id.btn_forgetPassword)
    public void forgotPassword(Button button) {
        ((LoginSignUp) getActivity()).loadRegisterFragment();

    }
    @Override
    public void onResponse(RWRequest request, Object response) {

    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {

    }
}

