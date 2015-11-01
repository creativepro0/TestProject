package app.rockkworld.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import app.rockkworld.R;

public class LoginFragment extends Fragment implements TextView.OnEditorActionListener, View.OnClickListener {


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
        View mView=inflater.inflate(R.layout.activity_sign_up, container, false);
        mView.findViewById(R.id.btn_signIn).setOnClickListener(this);
        mView.findViewById(R.id.btn_signUp).setOnClickListener(this);
        mView.findViewById(R.id.btn_forgetPassword).setOnClickListener(this);
        return mView;
    }


    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_GO) {

        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signIn:
                break;
            case R.id.btn_signUp:
                break;
            case R.id.btn_forgetPassword:
                break;
        }
    }
}

/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 * <p/>
 * See the Android Training lesson <a href=
 * "http://developer.android.com/training/basics/fragments/communicating.html"
 * >Communicating with Other Fragments</a> for more information.
 */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }
