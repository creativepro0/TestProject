package app.rockkworld.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.HashMap;

import app.rockkworld.R;
//import app.rockkworld.activities.LoginSignUpActivity;
//import app.rockkworld.activities.RWActivity;
//import app.rockkworld.adapters.PostsAdapter;
//import app.rockkworld.dialogs.LoadingDialog;
//import app.rockkworld.model.Login;
//import app.rockkworld.model.NewsFeedModel;
//import app.rockkworld.model.UserPost;
//import app.rockkworld.network.APIs;
//import app.rockkworld.utils.MLog;
//import app.rockkworld.utils.PrefUtils;
//import app.rockkworld.utils.Utils;
import app.rockkworld.activities.LoginSignUpActivity;
import app.rockkworld.adapters.PostsAdapter;
import app.rockkworld.dialogs.LoadingDialog;
import app.rockkworld.models.NewsFeedModel;
import app.rockkworld.models.UserPostRoot;
import app.rockkworld.utils.APIs;
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

    int color;
    public NewFeedFragment() {
    }
    @SuppressLint("ValidFragment")
    public NewFeedFragment(int color) {
        this.color = color;
    }

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

        View view=inflater.inflate(R.layout.fragment_news_feeds,null);

        return view;
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

        NewsFeedModel newFeedResponse= (NewsFeedModel) response;
        ArrayList<UserPostRoot> posts = newFeedResponse.getPosts();
        if (posts!=null) {
            if (posts.size()>0)
            MLog.d("Post", posts.get(0).getPost().toString());
        }else {
            MLog.d("Post", "Post ==null");
        }
//        if (posts!=null){
//            MLog.d("NesFeed","posts count = "+posts.size());
//        }
        Utils.hideDialog(loadingDialog);
        ListView list= (ListView) getView().findViewById(R.id.list_newFeeds);
        PostsAdapter adapter=new PostsAdapter(getActivity(),0,posts);
        list.setAdapter(adapter);
    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {
//        Utils.hideDialog(loadingDialog);
    }
}
