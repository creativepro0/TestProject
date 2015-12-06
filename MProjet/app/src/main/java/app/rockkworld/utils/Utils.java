package app.rockkworld.utils;

import android.app.Dialog;
import android.content.Context;

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
}
