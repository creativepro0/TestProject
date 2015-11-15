package app.rockkworld.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import app.rockkworld.R;
import app.rockkworld.activities.LoginSignUp;
import app.rockkworld.activities.WallActivity;
import app.rockkworld.model.Login;
import app.rockkworld.network.APIs;
import app.rockkworld.network.MRequest;
import app.rockkworld.network.MVolleyManager;
import app.rockkworld.network.ResponseListner;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements TextView.OnEditorActionListener, ResponseListner {


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
        View mView=inflater.inflate(R.layout.fragment_login, container, false);
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
//        Intent intent=new Intent(getActivity(), WallActivity.class);
//        getActivity().startActivity(intent);
//        getActivity().finish();

        MRequest loginReq=new MRequest(APIs.URL_Login(),this,Login.class);
        MVolleyManager.getInstance().addToQueue(loginReq);
    }

    @OnClick(R.id.btn_signUp)
    public void signUp(Button button) {
        ((LoginSignUp)getActivity()).loadRegisterFragment();

    }

    @OnClick(R.id.btn_forgetPassword)
    public void forgotPassword(Button button) {
        ((LoginSignUp)getActivity()).loadRegisterFragment();

    }


    @Override
    public void onResponse(MRequest request, Object response) {

    }

    @Override
    public void onErrorResponse(MRequest request, VolleyError error) {

    }
}

