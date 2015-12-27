package app.rockkworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 27/12/15.
 */
public class UserPostRoot implements Serializable{

    @SerializedName("Userpost")
    UserPost post;

    public UserPost getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "UserPostRoot{" +
                "post=" + post +
                '}';
    }
}
