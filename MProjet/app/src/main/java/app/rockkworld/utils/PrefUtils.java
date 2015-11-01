package app.rockkworld.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import app.rockkworld.model.UserMetaDetail;

/**
 * Created by divya on 31/10/15.
 */
public class PrefUtils {
    public static final String LOGIN_PREF_FILE = "Login_ShrdPref";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_ID = "userID";
    private static PrefUtils prefUtils;
    private Context context;

    private PrefUtils(Context context) {

        this.context = context;
    }

    public static void init(Context context) {
        if (prefUtils == null) {
            prefUtils = new PrefUtils(context);
        }
    }

    public static PrefUtils get() {
        return prefUtils;
    }

    public boolean isLoggedIn() {
        SharedPreferences logiPref = context.getSharedPreferences(LOGIN_PREF_FILE, Context.MODE_PRIVATE);
        return !TextUtils.isEmpty(logiPref.getString(KEY_USER_ID, null));
    }

    public UserMetaDetail getUserDetail() {
        UserMetaDetail userDetail = new UserMetaDetail();
        userDetail.setName("Rakesh");
        userDetail.setDp("39");
        userDetail.setUid("39");
        return userDetail;
    }
}
