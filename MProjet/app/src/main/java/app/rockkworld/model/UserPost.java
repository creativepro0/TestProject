package app.rockkworld.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 10/8/15.
 */
public class UserPost implements Serializable {

    @SerializedName("id")
    private String postID;
    @SerializedName("posted_by")
    private String postedBy;
    @SerializedName("post_title")
    private String postTitle;
    @SerializedName("post_data")
    private String postData;
    @SerializedName("post_image")
    private String postImage;
    @SerializedName("type")
    private String postType;
    @SerializedName("permissions")
    private String visibilityPermission;
    @SerializedName("created")
    private String dateCreated;
    @SerializedName("modified")
    private String dateModified;
    @SerializedName("LikeUnlikeByYou")
    private String likeUnlike;
    @SerializedName("like")
    private int likeStatus;
    @SerializedName("dislike")
    private int disLikeStatus;
    @SerializedName("commentsCount")
    private int commentCount;
    @SerializedName("sharedby")
    private ArrayList<String> sharedByArr;
    @SerializedName("tag")
    private ArrayList<String> tagArr;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("full_name")
    private String displayName;
    @SerializedName("profile_photo")
    private String profilePhoto;


    @Override
    public String toString() {
        return "UserPost{" +
                "postID='" + postID + '\'' +
                ", postedBy='" + postedBy + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postData='" + postData + '\'' +
                ", postImage='" + postImage + '\'' +
                ", postType='" + postType + '\'' +
                ", visibilityPermission='" + visibilityPermission + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", likeUnlike='" + likeUnlike + '\'' +
                ", likeStatus=" + likeStatus +
                ", disLikeStatus=" + disLikeStatus +
                ", commentCount=" + commentCount +
                ", sharedByArr=" + sharedByArr +
                ", tagArr=" + tagArr +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getVisibilityPermission() {
        return visibilityPermission;
    }

    public void setVisibilityPermission(String visibilityPermission) {
        this.visibilityPermission = visibilityPermission;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getLikeUnlike() {
        return likeUnlike;
    }

    public void setLikeUnlike(String likeUnlike) {
        this.likeUnlike = likeUnlike;
    }

    public int getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(int likeStatus) {
        this.likeStatus = likeStatus;
    }

    public int getDisLikeStatus() {
        return disLikeStatus;
    }

    public void setDisLikeStatus(int disLikeStatus) {
        this.disLikeStatus = disLikeStatus;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public ArrayList<String> getSharedByArr() {
        return sharedByArr;
    }

    public void setSharedByArr(ArrayList<String> sharedByArr) {
        this.sharedByArr = sharedByArr;
    }

    public ArrayList<String> getTagArr() {
        return tagArr;
    }

    public void setTagArr(ArrayList<String> tagArr) {
        this.tagArr = tagArr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }


    //    @SerializedName("id")
//    private String id;
//    @SerializedName("uid")
//    private String uid;
//    @SerializedName("timestamp")
//    private String timeStamp;
//    @SerializedName("msg")
//    private String msg;
//    @SerializedName("img")
//    ArrayList<String> imgs;
//    @SerializedName("like")
//    private String likeCount;
//    @SerializedName("dislike")
//    private String dislikeCount;
//    @SerializedName("commentsCount")
//    private String commentsCount;
//    @SerializedName("tag")
//    ArrayList<String> taggedIDs;
//    @SerializedName("sharedby")
//    ArrayList<String> sharedBydIDs;
//
//    private boolean likeStatus;
//    private boolean dislikeStatus;
//
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public String getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(String timeStamp) {
//        this.timeStamp = timeStamp;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getLikeCount() {
//        return likeCount;
//    }
//
//    public void setLikeCount(String likeCount) {
//        this.likeCount = likeCount;
//    }
//
//    public String getDislikeCount() {
//        return dislikeCount;
//    }
//
//    public void setDislikeCount(String dislikeCount) {
//        this.dislikeCount = dislikeCount;
//    }
//
//    public String getCommentsCount() {
//        return commentsCount;
//    }
//
//    public void setCommentsCount(String commentsCount) {
//        this.commentsCount = commentsCount;
//    }
//
//    public ArrayList<String> getTaggedIDs() {
//        return taggedIDs;
//    }
//
//    public void setTaggedIDs(ArrayList<String> taggedIDs) {
//        this.taggedIDs = taggedIDs;
//    }
//
//    public ArrayList<String> getSharedBydIDs() {
//        return sharedBydIDs;
//    }
//
//    public void setSharedBydIDs(ArrayList<String> sharedBydIDs) {
//        this.sharedBydIDs = sharedBydIDs;
//    }
//
//    public ArrayList<String> getImgs() {
//        return imgs;
//    }
//
//    public void setImgs(ArrayList<String> imgs) {
//        this.imgs = imgs;
//    }
//
//    public boolean getLikeStatus() {
//        return likeStatus;
//    }
//
//    public void setLikeStatus(boolean likeStatus) {
//        this.likeStatus = likeStatus;
//    }
//
//    public boolean getDislikeStatus() {
//        return dislikeStatus;
//    }
//
//    public void setDislikeStatus(boolean dislikeStatus) {
//        this.dislikeStatus = dislikeStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "UserPost{" +
//                "id='" + id + '\'' +
//                ", uid='" + uid + '\'' +
//                ", timeStamp='" + timeStamp + '\'' +
//                ", msg='" + msg + '\'' +
//                ", imgs=" + imgs +
//                ", likeCount='" + likeCount + '\'' +
//                ", dislikeCount='" + dislikeCount + '\'' +
//                ", commentsCount='" + commentsCount + '\'' +
//                ", taggedIDs=" + taggedIDs +
//                ", sharedBydIDs=" + sharedBydIDs +
//                '}';
//    }
}
