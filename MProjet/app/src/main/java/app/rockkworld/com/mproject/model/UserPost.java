package app.rockkworld.com.mproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 10/8/15.
 */
public class UserPost implements Serializable{


    @SerializedName("id")
    private String id;
    @SerializedName("uid")
    private String uid;
    @SerializedName("timestamp")
    private String timeStamp;
    @SerializedName("msg")
    private String msg;
    @SerializedName("img")
    ArrayList<String> imgs;
    @SerializedName("like")
    private String likeCount;
    @SerializedName("dislike")
    private String dislikeCount;
    @SerializedName("commentsCount")
    private String commentsCount;
    @SerializedName("tag")
    ArrayList<String> taggedIDs;
    @SerializedName("sharedby")
    ArrayList<String> sharedBydIDs;

    private boolean likeStatus;
    private boolean dislikeStatus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public ArrayList<String> getTaggedIDs() {
        return taggedIDs;
    }

    public void setTaggedIDs(ArrayList<String> taggedIDs) {
        this.taggedIDs = taggedIDs;
    }

    public ArrayList<String> getSharedBydIDs() {
        return sharedBydIDs;
    }

    public void setSharedBydIDs(ArrayList<String> sharedBydIDs) {
        this.sharedBydIDs = sharedBydIDs;
    }

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public boolean getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public boolean getDislikeStatus() {
        return dislikeStatus;
    }

    public void setDislikeStatus(boolean dislikeStatus) {
        this.dislikeStatus = dislikeStatus;
    }

    @Override
    public String toString() {
        return "UserPost{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", msg='" + msg + '\'' +
                ", imgs=" + imgs +
                ", likeCount='" + likeCount + '\'' +
                ", dislikeCount='" + dislikeCount + '\'' +
                ", commentsCount='" + commentsCount + '\'' +
                ", taggedIDs=" + taggedIDs +
                ", sharedBydIDs=" + sharedBydIDs +
                '}';
    }
}
