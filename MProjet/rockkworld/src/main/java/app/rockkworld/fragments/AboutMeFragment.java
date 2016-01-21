package app.rockkworld.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.rockkworld.R;
import app.rockkworld.models.UserProfileModel;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rohit on 1/1/16.
 */
public class AboutMeFragment extends BaseFragment {
    private static final String[] KEYS = {"location", "city", "zipcode", "dob", "forum", "relationship", "about_me", "i_like_to_meet", "movies", "interests", "music", "smoker", "drinker"};

    @Bind(R.id.scrollContainer)
    LinearLayout linearLayout;

    public static AboutMeFragment newInstance(UserProfileModel.UserData user) {
        AboutMeFragment aboutMeFragment = new AboutMeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        aboutMeFragment.setArguments(bundle);
        return aboutMeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout.removeAllViews();
        Bundle arguments = getArguments();
        UserProfileModel.UserData user = (UserProfileModel.UserData) arguments.getSerializable("user");
        getViewWithInfo(linearLayout, user);
    }

    private void getViewWithInfo(LinearLayout linearLayout, UserProfileModel.UserData user) {
        for (int i = 0; i < 13; i++) {
            View inflate = LayoutInflater.from(mActivty).inflate(R.layout.layout_about_card, linearLayout, false);
            linearLayout.addView(inflate);

            TextView title = (TextView) inflate.findViewById(R.id.title);

            String key = KEYS[i];

            key = key.replace("_", " ");
            if (key.length() > 0) {
                key = key.substring(0, 1).toUpperCase() + key.substring(1);
            }
            title.setText(key);
            TextView description = (TextView) inflate.findViewById(R.id.description);
            String value = user.getString(KEYS[i]);
            description.setText(TextUtils.isEmpty(value) ? "NA" : value);

        }
    }
}
