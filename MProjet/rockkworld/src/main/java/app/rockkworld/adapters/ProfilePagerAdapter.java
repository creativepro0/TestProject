package app.rockkworld.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.rockkworld.fragments.AboutMeFragment;
import app.rockkworld.fragments.NewFeedFragment;
import app.rockkworld.models.UserProfileModel;

/**
 * Created by rohit on 1/1/16.
 */
public class ProfilePagerAdapter extends FragmentPagerAdapter {
    private final FragmentManager fm;
    private final UserProfileModel.UserData user;

    private static final String[] TITLE = {"About Me", "Time Line"};


    public ProfilePagerAdapter(FragmentManager fm, UserProfileModel.UserData user) {
        super(fm);
        this.fm = fm;
        this.user = user;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AboutMeFragment.newInstance(user);
            case 1:
                return NewFeedFragment.newInstance(null);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }
}
