package app.rockkworld.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import app.rockkworld.R;
import app.rockkworld.fragments.LoginFragment;
import app.rockkworld.fragments.RegisterFragment;
import app.rockkworld.utils.MLog;
import app.rockkworld.utils.Utils;

public class LoginSignUpActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        loadLoginFragment();
    }

    public void loadLoginFragment() {
        loadLoginFragment(R.id.fragmentContainer, new Bundle());
    }

    public void loadLoginFragment(int viewId, Bundle bundle) {
        LoginFragment loginFragment = LoginFragment.newInstance(bundle);
        loginFragment.setArguments(bundle);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        Utils.commitTransactions(getSupportFragmentManager(), viewId, loginFragment, customAnimations, false);
    }

    public void loadRegisterFragment() {
        loadRegisterFragment(R.id.fragmentContainer, new Bundle());
    }

    public void loadRegisterFragment(int viewId, Bundle extras) {
        RegisterFragment registerFragment = RegisterFragment.newInstance(extras);
        registerFragment.setArguments(extras);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        Utils.commitTransactions(getSupportFragmentManager(), viewId, registerFragment, customAnimations, true);
    }

//    private void commitTransactions(int viewId, Fragment fragment, int[] customAnimations,boolean isAddToBackStack) {
//
//        String mTag = fragment.getClass().getSimpleName();
//        MLog.d("FT",mTag);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        boolean isPopBackStack = fragmentManager.popBackStackImmediate(mTag, 0);
//        if (!isPopBackStack) {
//            if (customAnimations != null) {
//                transaction.setCustomAnimations(customAnimations[0], customAnimations[1], customAnimations[2], customAnimations[3]);
//            }
//            if (isAddToBackStack) {
//                transaction.addToBackStack(mTag);
//            }
//            transaction.replace(viewId, fragment, mTag);
//            transaction.commit();
//            return;
//        }
////        transaction.replace(viewId, fragment, mTag);
////        if(isAddToBackStack)
////            transaction.addToBackStack(mTag);
////        transaction.commit();
//    }

}
