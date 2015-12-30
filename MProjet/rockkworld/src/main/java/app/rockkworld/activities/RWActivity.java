package app.rockkworld.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.rockkworld.R;
import app.rockkworld.adapters.ViewPagerAdapter;
import app.rockkworld.fragments.NewFeedFragment;
import app.rockkworld.fragments.ProfileViewFragment;
import app.rockkworld.utils.Utils;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RWActivity extends AppCompatActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawer;
//
//    @Bind(R.id.menu_drawer)
//    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rw);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);


//        MenuUtils utils = new MenuUtils();
//        utils.initMenu(PrefUtils.get().getUserPref(PrefUtils.UserPref.DISPLAY_NAME), layout, new MenuUtils.OnMenuClickListener() {
//            @Override
//            public void onMenuClick(View view, String tag) {
//
//            }
//        });

        NewFeedFragment newFeedFragment = NewFeedFragment.newInstance(null);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        Utils.commitTransactions(getSupportFragmentManager(),R.id.rw_fragmentContainer,newFeedFragment,customAnimations, false);

    }


    @OnClick(R.id.btn_hambugerMenu)
    public void toggleHambuger(View button) {
        if (mDrawer != null) {
            if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                mDrawer.closeDrawer(GravityCompat.START);
            } else {
                mDrawer.openDrawer(GravityCompat.START);
            }
        }
    }

//    @OnClick(R.id.btn_search)
//    public void openSearch(ImageView button) {
//    }
    @OnClick(R.id.btn_profile)
    public void showProfile(View button) {
        ProfileViewFragment newFeedFragment = ProfileViewFragment.newInstance(null);
        int[] customAnimations = new int[]{R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right};
        Utils.commitTransactions(getSupportFragmentManager(),R.id.rw_fragmentContainer,newFeedFragment,customAnimations, true);
    }
}
