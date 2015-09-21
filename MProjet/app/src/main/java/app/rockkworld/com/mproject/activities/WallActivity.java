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

public class WallActivity extends AppCompatActivity {

    Hashtable<String, UserMetaDetail> userMap;
    ArrayList<UserPost> postsArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);


        UserPostListModel posts = new GsonBuilder().create().fromJson(TestConstants.RESPONSE_NEWSFEEDS, UserPostListModel.class);
        postsArr = posts.getPosts();
        userMap = posts.getUserMap();


//        CardView headerView = (CardView) getLayoutInflater().inflate(R.layout.listview_header, null);

        ListView list = (ListView) findViewById(R.id.postsList);

        PostsAdapter postsAdapter = new PostsAdapter(this, -1, postsArr, userMap);

//        list.addHeaderView(headerView);
        list.setAdapter(postsAdapter);

//        Enumeration<String> keys = userMap.keys();
//
//        while (keys.hasMoreElements()) {
//            String s = keys.nextElement();
//            UserMetaDetail userMetaDetail = userMap.get(s);
//            Log.d("fhj", "key: " + s + "---> " + userMetaDetail);
//        }

//        for (int i=0;i<postsArr.size();i++) {
//            Log.d("fhj", "pos[ " + i + "] ---> " + postsArr.get(i));
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wall, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
