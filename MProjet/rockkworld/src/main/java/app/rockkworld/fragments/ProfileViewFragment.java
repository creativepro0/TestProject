package app.rockkworld.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.nostra13.universalimageloader.core.ImageLoader;

import app.rockkworld.R;
import app.rockkworld.adapters.ProfilePagerAdapter;
import app.rockkworld.models.NewsFeedModel;
import app.rockkworld.models.UserProfileModel;
import app.rockkworld.utils.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.views.CircularImageView;
import app.rockkworld.volley.GsonRequest;
import app.rockkworld.volley.RWRequest;
import app.rockkworld.volley.ResponseListener;
import app.rockkworld.volley.VolleyManager;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by divya on 30/12/15.
 */
public class ProfileViewFragment extends BaseFragment implements ResponseListener<UserProfileModel> {

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.vp_pager)
    ViewPager viewPager;
    @Bind(R.id.tv_userName)
    TextView tv_userName;

    @Bind(R.id.tv_city)
    TextView tv_city;



    @Bind(R.id.civ_userImage)
    CircularImageView civ_userImage;

    public ProfileViewFragment() {
    }


    public static ProfileViewFragment newInstance(Bundle args) {
        ProfileViewFragment fragment = new ProfileViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);
        ButterKnife.bind(this, view);
        fetchProfileData();
        return view;
    }

    private void fetchProfileData() {
        GsonRequest loginReq = new GsonRequest(APIs.URL_UserProfile(), null, this, UserProfileModel.class);
        VolleyManager.addToQueue(loginReq);
    }

    @Override
    public void onResponse(RWRequest<UserProfileModel> request, UserProfileModel response) {
        UserProfileModel profileData = (UserProfileModel) response;

        if (response != null) {
            UserProfileModel.UserData userDetail = response.getUserDetail();//.getUserDetail();
            ImageLoader.getInstance().displayImage(APIs.URL_GetUserImage(userDetail.getProfilePhoto()),civ_userImage);
            tv_userName.setText(userDetail.getDiaplayName());
            tv_city.setText(userDetail.getCity());
            viewPager.setAdapter(new ProfilePagerAdapter(getChildFragmentManager(), userDetail));
            tabLayout.setupWithViewPager(viewPager);

            MLog.d("Profile data ------------------------>>>>>>>>>");
            MLog.d("Profile", profileData.getUserDetail().toString());
        } else {
            MLog.d("Profile data null");
        }
    }

    @Override
    public void onErrorResponse(RWRequest<UserProfileModel> request, VolleyError error) {

    }
}
