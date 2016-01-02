package app.rockkworld.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import app.rockkworld.dialogs.LoadingDialog;

/**
 * Created by divya on 29/11/15.
 */
public class Utils {

    public static void showDialog(Dialog dialog){
        if (dialog!=null){
            dialog.show();
        }
    }

    public static void hideDialog(Dialog dialog){
        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
            dialog=null;
        }
    }

    public static void commitTransactions(FragmentManager fragmentManager ,int viewId, Fragment fragment, int[] customAnimations,boolean isAddToBackStack) {

        String mTag = fragment.getClass().getSimpleName();
        MLog.d("FT",mTag);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        boolean isPopBackStack = fragmentManager.popBackStackImmediate(mTag, 0);
        if (!isPopBackStack) {
            if (customAnimations != null) {
                transaction.setCustomAnimations(customAnimations[0], customAnimations[1], customAnimations[2], customAnimations[3]);
            }
            if (isAddToBackStack) {
                transaction.addToBackStack(mTag);
            }
            transaction.replace(viewId, fragment, mTag);
            transaction.commit();
            return;
        }
//        transaction.replace(viewId, fragment, mTag);
//        if(isAddToBackStack)
//            transaction.addToBackStack(mTag);
//        transaction.commit();
    }

}
