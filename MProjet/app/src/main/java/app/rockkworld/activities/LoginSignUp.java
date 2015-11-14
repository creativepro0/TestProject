package app.rockkworld.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import app.rockkworld.R;
import app.rockkworld.fragments.LoginFragment;
import app.rockkworld.fragments.RegisterFragment;

public class LoginSignUp extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        loadRegisterFragment();
    }

    public void loadLoginFragment() {
        loadLoginFragment(R.id.fragmentContainer, new Bundle());
    }

    public void loadLoginFragment(int viewId, Bundle bundle) {
        LoginFragment loginFragment = LoginFragment.newInstance(bundle);
        loginFragment.setArguments(bundle);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        commitTransactions(viewId, loginFragment, customAnimations, "loginFragment");
    }

    public void loadRegisterFragment() {
        loadRegisterFragment(R.id.fragmentContainer, new Bundle());
    }

    public void loadRegisterFragment(int viewId, Bundle extras) {
        RegisterFragment registerFragment = RegisterFragment.newInstance(extras);
        registerFragment.setArguments(extras);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        commitTransactions(viewId, registerFragment, customAnimations, "registerFragment");
    }

    private void commitTransactions(int viewId, Fragment fragment, int[] customAnimations, String mTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (customAnimations != null) {
            transaction.setCustomAnimations(customAnimations[0], customAnimations[1], customAnimations[2], customAnimations[3]);
        }
        transaction.replace(viewId, fragment, mTag);
        transaction.addToBackStack(mTag);
        transaction.commit();
    }

}
