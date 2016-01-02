package app.rockkworld.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by divya on 27/12/15.
 */
public class NewsFeedModel {
    @SerializedName("user_post")
    ArrayList<UserPost> posts;

    public ArrayList<UserPost> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "NewsFeedModel{" +
                "posts=" + posts +
                '}';
    }
}
