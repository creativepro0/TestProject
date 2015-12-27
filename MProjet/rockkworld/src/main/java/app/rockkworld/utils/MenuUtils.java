package app.rockkworld.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.rockkworld.R;

/**
 * Created by rohit on 15/11/15.
 */
public class MenuUtils implements View.OnClickListener {

    public static final String HOME = "HOME";
    public static final String MY_PROFILE = "MY PROFILE";
    public static final String MY_FRIENDS = "MY FRIENDS";
    public static final String NOTIFICATION = "NOTIFICATION";
    public static final String SETTINGS = "SETTINGS";
    public static final String LOG_OUT = "LOG OUT";
    private static final String[] MENU = {"Hi, %s", HOME, MY_PROFILE, MY_FRIENDS, NOTIFICATION, SETTINGS, LOG_OUT};
    private OnMenuClickListener onMenuClickListener;

    public interface OnMenuClickListener {
        void onMenuClick(View view, String tag);
    }

    public void initMenu(String userName, ViewGroup group, OnMenuClickListener onMenuClickListener) {
        this.onMenuClickListener = onMenuClickListener;
        group.removeAllViews();
//        LayoutInflater inflater = LayoutInflater.from(group.getContext());
//        for (int i = 0; i < MENU.length; i++) {
//            TextView view = (TextView) inflater.inflate(R.layout.layout_menu_item, group, false);
//            if (i != 0) {
//                view.setOnClickListener(this);
//                view.setTag(MENU[i]);
//                view.setText(MENU[i]);
//            } else {
//                view.setText(String.format(MENU[i], userName));
//            }
//            group.addView(view);
//        }
    }

    @Override
    public void onClick(View v) {
        onMenuClickListener.onMenuClick(v, v.getTag().toString());
    }
}
