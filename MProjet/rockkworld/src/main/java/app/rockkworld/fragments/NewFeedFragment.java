package app.rockkworld.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
import app.rockkworld.adapters.EndlessRecyclerForLiveFeedOnScrollListener;
import app.rockkworld.adapters.PostsAdapter;
import app.rockkworld.dialogs.LoadingDialog;
import app.rockkworld.models.NewsFeedModel;
import app.rockkworld.models.UserPost;
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
    int page = 1;
    private ListView list;
    private View view;

    public NewFeedFragment() {
    }

    @SuppressLint("ValidFragment")
    public NewFeedFragment(int color) {
        this.color = color;
    }

    public static NewFeedFragment newInstance(Bundle args) {
        NewFeedFragment fragment = new NewFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_news_feeds, null);
            list = (ListView) view.findViewById(R.id.list_newFeeds);
            list.setOnScrollListener(new EndlessRecyclerForLiveFeedOnScrollListener() {
                @Override
                public void onLoadMore(String id) {
                    makeApiCall(id);
                }

                @Override
                public void updateLastItem(EndlessRecyclerForLiveFeedOnScrollListener scrollListener, AbsListView absListView, int position) {

                }

                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                }
            });
            page=1;
            makeApiCall("");
        }
        return view;
    }

    LoadingDialog loadingDialog;

    private void makeApiCall(String id) {
        PrefUtils prefUtils = PrefUtils.get();
        String userID = prefUtils.getUserPref(PrefUtils.UserPref.USER_ID);
        if (TextUtils.isEmpty(userID)) {
            Intent intent = new Intent(getActivity(), LoginSignUpActivity.class);
            getActivity().startActivity(intent);
        } else {
            if (page <= 1) {
                loadingDialog = new LoadingDialog(getActivity());
                Utils.showDialog(loadingDialog);
            }
            HashMap<String, String> params = new HashMap<>();
            params.put("profileId", userID);
            // id wala logic
            params.put("lastID", id);
            params.put("page", "" + page);
            GsonRequest loginReq = new GsonRequest(APIs.URL_NewFeed(params), params, this, NewsFeedModel.class);
            MLog.d("FFF", loginReq.getUrl());
            VolleyManager.addToQueue(loginReq);
        }
    }


    @Override
    public void onResponse(RWRequest request, Object response) {

        NewsFeedModel newFeedResponse = (NewsFeedModel) response;
        ArrayList<UserPost> posts = newFeedResponse.getPosts();
        if (posts != null) {
            if (posts.size() > 0) {
                MLog.d("Post", posts.get(0).toString());
                page++;
                MLog.d("FFF", "postID----------> " + posts.get(0).getPostID() + " ------> " + posts.size());
            }
        } else {
            MLog.d("Post", "Post ==null");
        }
//        if (posts!=null){
//            MLog.d("NesFeed","posts count = "+posts.size());
//        }
        Utils.hideDialog(loadingDialog);

        ListAdapter adapter1 = list.getAdapter();
        if (adapter1 == null) {
            PostsAdapter adapter = new PostsAdapter(this, 0, posts);
            list.setAdapter(adapter);
            return;
        }
        ((PostsAdapter) adapter1).addAll(posts);
        ((PostsAdapter) adapter1).notifyDataSetChanged();
        MLog.d("FFF", "adpaterItem count----------> " + adapter1.getCount());


    }

    @Override
    public void onErrorResponse(RWRequest request, VolleyError error) {
        Utils.hideDialog(loadingDialog);
        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }


}
