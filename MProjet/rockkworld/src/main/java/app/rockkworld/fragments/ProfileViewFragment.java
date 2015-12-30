package app.rockkworld.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;

import app.rockkworld.R;
import app.rockkworld.models.NewsFeedModel;
import app.rockkworld.models.UserProfileModel;
import app.rockkworld.utils.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.volley.GsonRequest;
import app.rockkworld.volley.RWRequest;
import app.rockkworld.volley.ResponseListener;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by divya on 30/12/15.
 */
public class ProfileViewFragment extends BaseFragment implements ResponseListener{

    public ProfileViewFragment() {
    }


    public static ProfileViewFragment newInstance(Bundle args){
        ProfileViewFragment fragment = new ProfileViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, null);
        fetchProfileData();
        return view;
    }

    private void fetchProfileData() {
        GsonRequest loginReq = new GsonRequest(APIs.URL_UserProfile(),null, this, UserProfileModel.class);
        VolleyManager.addToQueue(loginReq);
    }

    @Override
    public void onResponse(RWRequest request, Object response) {
        UserProfileModel profileData= (UserProfileModel) response;

        if (response!=null){
            MLog.d("Profile data ------------------------>>>>>>>>>");
            MLog.d("Profile",profileData.getUserDetail().toString());
        }else {
            MLog.d("Profile data null");
        }
    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {

    }
}
