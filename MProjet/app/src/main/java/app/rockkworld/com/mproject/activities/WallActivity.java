package app.rockkworld.com.mproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import app.rockkworld.R;
import app.rockkworld.com.mproject.adapters.PostsAdapter;
import app.rockkworld.com.mproject.model.UserMetaDetail;
import app.rockkworld.com.mproject.model.UserPost;
import app.rockkworld.com.mproject.model.UserPostListModel;
import app.rockkworld.com.mproject.utils.TestConstants;
import butterknife.Bind;
import butterknife.ButterKnife;

public class WallActivity extends AppCompatActivity {

    Hashtable<String, UserMetaDetail> userMap;
    ArrayList<UserPost> postsArr;

    @Bind(R.id.postsList)
    ListView feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        setContentView(R.layout.activity_wall);
        populateFeeds();


    }

    private void populateFeeds() {
        UserPostListModel posts = new GsonBuilder().create().fromJson(TestConstants.RESPONSE_NEWSFEEDS, UserPostListModel.class);
        postsArr = posts.getPosts();
        userMap = posts.getUserMap();

        PostsAdapter postsAdapter = new PostsAdapter(this, -1, postsArr, userMap);
        feedList.setAdapter(postsAdapter);

//        CardView headerView = (CardView) getLayoutInflater().inflate(R.layout.listview_header, null);
//        list.addHeaderView(headerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_wall, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
