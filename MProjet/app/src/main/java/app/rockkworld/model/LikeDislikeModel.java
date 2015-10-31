package app.rockkworld.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import app.rockkworld.model.UserMetaDetail;

/**
 * Created by divya on 15/9/15.
 */
public class LikeDislikeModel implements Serializable {
    @SerializedName("startIndex")
    int startIndex;
    @SerializedName("count")
    int count;
    @SerializedName("maxCount")
    int maxCount;

    @SerializedName("Likes")
    ArrayList<UserMetaDetail> likes;
    @SerializedName("Dislikes")
    ArrayList<UserMetaDetail> dislikes;

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

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public ArrayList<UserMetaDetail> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<UserMetaDetail> likes) {
        this.likes = likes;
    }

    public ArrayList<UserMetaDetail> getDislikes() {
        return dislikes;
    }

    public void setDislikes(ArrayList<UserMetaDetail> dislikes) {
        this.dislikes = dislikes;
    }
}
