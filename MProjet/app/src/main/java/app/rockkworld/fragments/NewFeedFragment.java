package app.rockkworld.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;

import java.util.HashMap;

import app.rockkworld.activities.LoginSignUpActivity;
import app.rockkworld.activities.RWActivity;
import app.rockkworld.dialogs.LoadingDialog;
import app.rockkworld.model.Login;
import app.rockkworld.model.NewsFeedModel;
import app.rockkworld.network.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.utils.PrefUtils;
import app.rockkworld.utils.Utils;
import app.rockkworld.volley.GsonRequest;
import app.rockkworld.volley.RWRequest;
import app.rockkworld.volley.ResponseListener;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by divya on 29/11/15.
 */
public class NewFeedFragment extends BaseFragment implements ResponseListener {

    public static NewFeedFragment newInstance(Bundle args){
        NewFeedFragment fragment = new NewFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    LoadingDialog loadingDialog;
    private void fetchData(){
        PrefUtils prefUtils = PrefUtils.get();
        String userID = prefUtils.getUserPref(PrefUtils.UserPref.USER_ID);
        if (TextUtils.isEmpty(userID)){
            Intent intent=new Intent(getActivity(), LoginSignUpActivity.class);
            getActivity().startActivity(intent);
        }else {
            loadingDialog=new LoadingDialog(getActivity());
            Utils.showDialog(loadingDialog);

            HashMap<String, String> params = new HashMap<String, String>();
            params.put("profileId",userID );
            params.put("page", "1");
            GsonRequest loginReq = new GsonRequest(APIs.URL_NewFeed()+userID, params, this, NewsFeedModel.class);
            VolleyManager.addToQueue(loginReq);
        }
    }
    @Override
    public void onResponse(RWRequest request, Object response) {

        Utils.hideDialog(loadingDialog);
        MLog.d("NesFeed",response.toString());

    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {
        Utils.hideDialog(loadingDialog);
    }
}
