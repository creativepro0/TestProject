package app.rockkworld.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Hashtable;

import app.rockkworld.R;
import app.rockkworld.adapters.PostsAdapter;
import app.rockkworld.model.UserMetaDetail;
import app.rockkworld.model.UserPost;
import app.rockkworld.model.NewsFeedModel;
import app.rockkworld.utils.TestConstants;
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
        setContentView(R.layout.activity_wall);
        ButterKnife.bind(this);
        populateFeeds();

    }

    private void populateFeeds() {
//        NewsFeedModel posts = new GsonBuilder().create().fromJson(TestConstants.RESPONSE_NEWSFEEDS, NewsFeedModel.class);
//        postsArr = posts.getPosts();
//        userMap = posts.getUserMap();
//
//        PostsAdapter postsAdapter = new PostsAdapter(this, -1, postsArr, userMap);
//        feedList.setAdapter(postsAdapter);

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
