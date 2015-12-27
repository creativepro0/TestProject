package app.rockkworld.fragments;

import android.content.Intent;
import android.os.Bundle;
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
import app.rockkworld.activities.LoginSignUpActivity;
import app.rockkworld.activities.RWActivity;
import app.rockkworld.dialogs.LoadingDialog;
import app.rockkworld.models.Login;
import app.rockkworld.utils.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.utils.PrefUtils;
import app.rockkworld.utils.Utils;
import app.rockkworld.volley.GsonRequest;
import app.rockkworld.volley.RWRequest;
import app.rockkworld.volley.ResponseListener;
import app.rockkworld.volley.VolleyManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements TextView.OnEditorActionListener, ResponseListener {

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
    LoadingDialog loadingDialog;
    @OnClick(R.id.btn_signIn)
    public void signIn(Button button) {

//        Intent intent=new Intent(getActivity(), RWActivity.class);
//        getActivity().startActivity(intent);
//        getActivity().finish();

        String usrName = usrNameET.getText().toString();
        String password = passwordET.getText().toString();
        if (TextUtils.isEmpty(usrName) || TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "UserName/Password can not be blank ", Toast.LENGTH_LONG).show();
            return;
        }
        loadingDialog=new LoadingDialog(getActivity());
        Utils.showDialog(loadingDialog);

        MLog.d("userName= " + usrName + " password= " + password);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", usrName);
        params.put("Password", password);
        GsonRequest loginReq = new GsonRequest(APIs.URL_Login(), params, this, Login.class);
        VolleyManager.addToQueue(loginReq);


    }

    @OnClick(R.id.btn_signUp)
    public void signUp(Button button) {
        ((LoginSignUpActivity) getActivity()).loadRegisterFragment();

    }

    @OnClick(R.id.btn_forgetPassword)
    public void forgotPassword(View button) {

    }

    @Override
    public void onResponse(RWRequest request, Object response) {

        Utils.hideDialog(loadingDialog);
        if (response != null && response instanceof Login) {
            Login loginRes = (Login) response;
            MLog.d(loginRes.toString());
            PrefUtils prefUtils = PrefUtils.get();
            HashMap<String,String> prefMap=new HashMap<String,String>();
            prefMap.put(PrefUtils.UserPref.USER_NAME,loginRes.getLoginLoginResult().getdName());
            prefMap.put(PrefUtils.UserPref.USER_ID, loginRes.getLoginLoginResult().getUid());
//            prefMap.put(PrefUtils.UserPref.DEVICE_INFO, loginRes.getLoginResult().getDeviceInfo());
            prefMap.put(PrefUtils.UserPref.DISPLAY_NAME, loginRes.getLoginLoginResult().getdName());
            prefMap.put(PrefUtils.UserPref.DISPLAY_PIC, loginRes.getLoginLoginResult().getdPic());
            prefUtils.deletePref(PrefUtils.LOGIN_PREF_FILE);
            prefUtils.putPrefMap(PrefUtils.LOGIN_PREF_FILE, prefMap);

            Intent intent=new Intent(getActivity(), RWActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }

    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {
        Utils.hideDialog(loadingDialog);
    }
}

