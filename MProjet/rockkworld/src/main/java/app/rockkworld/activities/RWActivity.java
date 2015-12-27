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

//        MenuUtils utils = new MenuUtils();
//        utils.initMenu(PrefUtils.get().getUserPref(PrefUtils.UserPref.DISPLAY_NAME), layout, new MenuUtils.OnMenuClickListener() {
//            @Override
//            public void onMenuClick(View view, String tag) {
//
//            }
//        });

//        NewFeedFragment newFeedFragment = NewFeedFragment.newInstance(null);
//        loadFragment(newFeedFragment, R.id.content_frame, null);

//        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_tabContent);
//        setupViewPager(viewPager);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
//        tabLayout.setupWithViewPager(viewPager);

//        setupTabIcon(tabLayout);

    }

//    private void setupTabIcon(TabLayout tabLayout) {
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_schedule_white);
////        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_white);
////        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search_white);
//    }

//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFrag(new NewFeedFragment(getResources().getColor(R.color.accent_material_light)), "");
////        adapter.addFrag(new NewFeedFragment(getResources().getColor(R.color.ripple_material_light)), "");
////        adapter.addFrag(new NewFeedFragment(getResources().getColor(R.color.button_material_dark)), "");
//        viewPager.setAdapter(adapter);
//    }

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
}
