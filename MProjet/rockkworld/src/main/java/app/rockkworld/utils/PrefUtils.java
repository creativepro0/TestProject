package app.rockkworld.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Created by divya on 31/10/15.
 */
public class PrefUtils {
    public static final String LOGIN_PREF_FILE = "Login_ShrdPref";
    public static final String PREF_KEY_USER_NAME = "userName";
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

    public void putStringPref(String sharedPrefName, String prefKey, String prefStrValue, String defalutStr) {
        SharedPreferences pref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(prefKey, prefStrValue);
        editor.apply();
    }

    public void putStringPref(String sharedPrefName, String prefKey, String prefStr) {
        putStringPref(sharedPrefName, prefKey, prefStr, null);
    }

    public String getUserPref(String prefKey) {
        return getUserPref(prefKey,null);
    }
    public String getUserPref(String prefKey,String defaultValue) {
        return context.getSharedPreferences(LOGIN_PREF_FILE,Context.MODE_PRIVATE).getString(prefKey, defaultValue);
    }
    public Map<String, ?> getUserPref() {
        SharedPreferences pref = context.getSharedPreferences(LOGIN_PREF_FILE, Context.MODE_PRIVATE);
        return pref.getAll();
    }

    public void deletePref(String prefFileName){
        SharedPreferences pref = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
        if (pref!=null) {
            pref.edit().clear().commit();
        }
    }
    public void putPrefMap(String sharedPrefName, Map<String, String> prefMap) {
        if (prefMap != null && prefMap.size() > 0) {
            SharedPreferences pref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            Set<String> keySet = prefMap.keySet();
            Iterator iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String mKey = (String) iterator.next();
                editor.putString(mKey, prefMap.get(mKey));
            }
            editor.apply();
        }
    }

    public static PrefUtils get() {
        return prefUtils;
    }

    public boolean isLoggedIn() {
        SharedPreferences logiPref = context.getSharedPreferences(LOGIN_PREF_FILE, Context.MODE_PRIVATE);
        return !TextUtils.isEmpty(logiPref.getString(KEY_USER_ID, null));
    }


    public static interface UserPref {
        String USER_NAME = "userName";
        String DEVICE_INFO = "deviceInfo";
        String USER_ID = "userID";
        String DISPLAY_NAME = "displayName";
        String DISPLAY_PIC = "displayPicUrl";
    }
}
