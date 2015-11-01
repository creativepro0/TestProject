package app.rockkworld.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by divya on 31/10/15.
 */
public class PrefUtils {
    public static final String LOGIN_PREF_FILE="Login_ShrdPref";
    public static final String KEY_USER_NAME="userName";
    public static final String KEY_USER_ID="userID";

    public static boolean isLoggedIN(Context context){
        SharedPreferences logiPref=context.getSharedPreferences(LOGIN_PREF_FILE,Context.MODE_PRIVATE);
        return !TextUtils.isEmpty(logiPref.getString(KEY_USER_ID,null));
    }
}
