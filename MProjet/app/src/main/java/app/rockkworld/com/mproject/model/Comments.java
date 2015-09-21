package app.rockkworld.com.mproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 15/9/15.
 */
public class Comments implements Serializable {
    @SerializedName("startIndex")
    int startIndex;
    @SerializedName("count")
    int count;
    @SerializedName("maxCount")
    int maxCount;
    @SerializedName("comments")
    ArrayList<UserComment> userComments;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountR() {
        return maxCount;
    }

    public void setCountR(int maxCount) {
        this.maxCount = maxCount;
    }

    public ArrayList<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(ArrayList<UserComment> userComments) {
        this.userComments = userComments;
    }

}
