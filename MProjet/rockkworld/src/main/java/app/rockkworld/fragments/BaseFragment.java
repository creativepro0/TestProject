package app.rockkworld.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by divya on 29/11/15.
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivty;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivty = activity;
    }
}
