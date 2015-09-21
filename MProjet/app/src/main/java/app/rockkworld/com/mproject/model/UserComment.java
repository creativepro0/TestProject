package app.rockkworld.com.mproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by divya on 16/9/15.
 */
public class UserComment implements Serializable {
    @SerializedName("id")
    private String id = "";
    @SerializedName("uid")
    private String uid = "";
    @SerializedName("username")
    private String userName = "";
    @SerializedName("msg")
    private String commentMsg = "";
    @SerializedName("image")
    private String commentImage = "";
    @SerializedName("ts")
    private String commentTS = "";


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentMsg() {
        return commentMsg;
    }

    public void setCommentMsg(String commentMsg) {
        this.commentMsg = commentMsg;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public String getCommentTS() {
        return commentTS;
    }

    public void setCommentTS(String commentTS) {
        this.commentTS = commentTS;
    }
}
