package app.rockkworld.com.mproject.utils;

import android.content.Context;
import android.content.SharedPreferences;

import app.rockkworld.com.mproject.model.UserMetaDetail;

/**
 * Created by divya on 16/9/15.
 */
public class SharedPrefUtils {
    private static final String USER_CREDENTIAL_PREF="UserCredential";
    private static final String PREF_USER_NAME="";
    private static final String PREF_USER_UID="";

    public static SharedPreferences getUserCredentialPref(Context context){
        return context.getSharedPreferences(USER_CREDENTIAL_PREF,Context.MODE_PRIVATE);
    }

    public static boolean isUserLoggedIn(Context context){
        return true;
    }
    public static UserMetaDetail getUserDetail(Context context){
        UserMetaDetail userDetail = new UserMetaDetail();
        userDetail.setName("Rakesh");
        userDetail.setDp("39");
        userDetail.setUid("39");
        return userDetail;
    }
}
