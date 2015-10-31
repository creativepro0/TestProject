package app.rockkworld.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by divya on 10/8/15.
 */
public class UserPostListModel implements Serializable{
    @SerializedName("user_post")
    ArrayList<UserPost> posts;

    @SerializedName("user")
    Hashtable<String,UserMetaDetail> userMap;


    public ArrayList<UserPost> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<UserPost> posts) {
        this.posts = posts;
    }

    public Hashtable<String, UserMetaDetail> getUserMap() {
        return userMap;
    }

    public void setUserMap(Hashtable<String, UserMetaDetail> userMap) {
        this.userMap = userMap;
    }
}
