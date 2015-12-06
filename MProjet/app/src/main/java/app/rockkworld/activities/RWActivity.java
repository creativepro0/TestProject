package app.rockkworld.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import app.rockkworld.R;
import app.rockkworld.fragments.NewFeedFragment;
import app.rockkworld.utils.MenuUtils;
import app.rockkworld.utils.PrefUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RWActivity extends AppCompatActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Bind(R.id.menu_drawer)
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rw);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);


//        TextView tv = (TextView) findViewById(R.id.welcomeTxt);
//        HashMap<String, String> userPref = (HashMap<String, String>) PrefUtils.get().getUserPref();
//        Set<String> keys = userPref.keySet();
//        Iterator<String> iterator = keys.iterator();
//        String str = "";
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            str += s + " : " + userPref.get(s) + "\n";
//        }
//        tv.setText(str);

        MenuUtils utils = new MenuUtils();
        utils.initMenu(PrefUtils.get().getUserPref(PrefUtils.UserPref.DISPLAY_NAME), layout, new MenuUtils.OnMenuClickListener() {
            @Override
            public void onMenuClick(View view, String tag) {

            }
        });

        NewFeedFragment newFeedFragment = NewFeedFragment.newInstance(null);
        loadFragment(newFeedFragment, R.id.content_frame, null);

    }

    @OnClick(R.id.btn_hambuger)
    public void toggleHambuger(ImageView button) {
        if (mDrawer != null) {
            if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                mDrawer.closeDrawer(GravityCompat.START);
            } else {
                mDrawer.openDrawer(GravityCompat.START);
            }
        }
    }

    @OnClick(R.id.btn_search)
    public void openSearch(ImageView button) {
    }

    public void loadFragment(Fragment fragment, int containerID, Bundle extras) {
        if (extras != null) {
            fragment.setArguments(extras);
        }
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        commitTransactions(containerID, fragment, customAnimations, "registerFragment");
    }

    private void commitTransactions(int viewId, Fragment fragment, int[] customAnimations, String mTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        boolean isPopBackStack = fragmentManager.popBackStackImmediate(mTag, 0);
        if (!isPopBackStack) {
            if (customAnimations != null) {
                transaction.setCustomAnimations(customAnimations[0], customAnimations[1], customAnimations[2], customAnimations[3]);
            }
            if (fragmentManager.findFragmentById(viewId) != null) {
                transaction.addToBackStack(mTag);
            }
            transaction.replace(viewId, fragment, mTag);
            transaction.commit();
            return;
        }
        transaction.replace(viewId, fragment, mTag);
//        transaction.addToBackStack(mTag);
        transaction.commit();
    }
}
