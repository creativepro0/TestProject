package app.rockkworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 27/12/15.
 */
public class UserPost implements Serializable{

    @SerializedName("id")
    String postID;
    @SerializedName("parent_id")
    String postParentID;
    @SerializedName("posted_by")
    String postedBy;
    @SerializedName("post_title")
    String postTitle;
    @SerializedName("post_data")
    String postText;
    @SerializedName("post_image")
    String postImage;
    @SerializedName("type")
    String postType;
    @SerializedName("permissions")
    String permissions;
    @SerializedName("created")
    String created;
    @SerializedName("modified")
    String modified;
    @SerializedName("LikeUnlikeByYou")
    String likeUnlikeBySelf;
    @SerializedName("like")
    String likeCount;
    @SerializedName("dislike")
    String dislikeCount;
    @SerializedName("commentsCount")
    String commentsCount;
    @SerializedName("sharedby")
    ArrayList<String> sharedBy;
    @SerializedName("tag")
    ArrayList<String> tag;
    @SerializedName("user_name")
    String userName;
    @SerializedName("full_name")
    String displayName;
    @SerializedName("profile_photo")
    String profilePic;

    public String getPostID() {
        return postID;
    }

    public String getPostParentID() {
        return postParentID;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public String getPostImage() {
        return postImage;
    }

    public String getPostType() {
        return postType;
    }

    public String getPermissions() {
        return permissions;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public String getLikeUnlikeBySelf() {
        return likeUnlikeBySelf;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public ArrayList<String> getSharedBy() {
        return sharedBy;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public String getUserName() {
        return userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public void setLikeUnlikeBySelf(String likeUnlikeBySelf) {
        this.likeUnlikeBySelf = likeUnlikeBySelf;
    }

    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setSharedBy(ArrayList<String> sharedBy) {
        this.sharedBy = sharedBy;
    }

    @Override
    public String toString() {
        return "UserPost{" +
                "postID='" + postID + '\'' +
                ", postParentID='" + postParentID + '\'' +
                ", postedBy='" + postedBy + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", postImage='" + postImage + '\'' +
                ", postType='" + postType + '\'' +
                ", permissions='" + permissions + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", likeUnlikeBySelf='" + likeUnlikeBySelf + '\'' +
                ", likeCount='" + likeCount + '\'' +
                ", dislikeCount='" + dislikeCount + '\'' +
                ", commentsCount='" + commentsCount + '\'' +
                ", sharedBy=" + sharedBy +
                ", tag=" + tag +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
/*
* public class UserPostRoot implements Serializable{

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
}*/