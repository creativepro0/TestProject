package app.rockkworld.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import app.rockkworld.R;
import app.rockkworld.activities.LoginSignUpActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by divya on 1/11/15.
 */
public class RegisterFragment extends BaseFragment implements TextView.OnEditorActionListener {


    @Bind(R.id.et_name)
    EditText tvName;

    @Bind(R.id.et_email)
    EditText tvEmail;

    @Bind(R.id.et_password)
    EditText tvPassword;

    @Bind(R.id.tv_selectDOB)
    TextView tvSelectDOB;

    @Bind(R.id.rg_gender)
    RadioGroup rgGender;

    @Bind(R.id.rBtn_female)
    RadioButton rBtnFemale;

    @Bind(R.id.rBtn_male)
    RadioButton rBtnMale;


    public static RegisterFragment newInstance(Bundle args) {
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RegisterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @OnClick(R.id.btn_signIn)
    public void signIn(Button button) {
        getFragmentManager().popBackStack();
    }

    @OnClick(R.id.btn_signUp)
    public void signUp(Button button) {
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_GO) {

        }
        return false;
    }

}
