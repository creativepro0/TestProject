package app.rockkworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by divya on 30/12/15.
 */
public class UserProfileModel {

    @SerializedName("UserDetail")
    UserData userDetail;

    public UserData getUserDetail() {
        return userDetail;
    }

    @Override
    public String toString() {
        return "UserProfileModel{" +
                "userDetail=" + userDetail +
                '}';
    }

    public class UserData {

        @SerializedName("User")
        User userDetail;
        @SerializedName("isFriend")
        String isFriend;
        @SerializedName("Posted_post")
        ArrayList<UserPostRoot> posts;
        @SerializedName("Listfriends")
        ArrayList<UserListElement> friends;
        @SerializedName("Profileimages")
        ArrayList<ImageListElement> images;


        @Override
        public String toString() {
            return "UserProfileModel{" +
                    "userDetail=" + userDetail +
                    ", isFriend='" + isFriend + '\'' +
                    ", posts=" + posts +
                    ", friends=" + friends +
                    ", images=" + images +
                    '}';
        }

        public User getUserDetail() {
            return userDetail;
        }
    }

    public class User implements Serializable {
        @SerializedName("id")
        String id;
        @SerializedName("user_name")
        String name;
        @SerializedName("full_name")
        String diaplayName;
        @SerializedName("email")
        String email;
        @SerializedName("gender")
        String gender;
        @SerializedName("profile_photo")
        String profilePhoto;
        @SerializedName("cover_photo")
        String coverPhoto;
        @SerializedName("credit_points")
        String creditPoints;
        @SerializedName("referral_code")
        String referralCode;
        @SerializedName("location")
        String location;
        @SerializedName("city")
        String city;
        @SerializedName("zipcode")
        String zipCode;
        @SerializedName("relationship")
        String relationship;
        @SerializedName("forum_sign")
        String forumSign;
        @SerializedName("about_me")
        String about;
        @SerializedName("i_like_to_meet")
        String likeToMeet;
        @SerializedName("movies")
        String movies;
        @SerializedName("interests")
        String interests;
        @SerializedName("music")
        String music;
        @SerializedName("smoker")
        String smoker;
        @SerializedName("drinker")
        String drinker;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDiaplayName() {
            return diaplayName;
        }

        public String getEmail() {
            return email;
        }

        public String getGender() {
            return gender;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public String getCoverPhoto() {
            return coverPhoto;
        }

        public String getCreditPoints() {
            return creditPoints;
        }

        public String getReferralCode() {
            return referralCode;
        }

        public String getLocation() {
            return location;
        }

        public String getCity() {
            return city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getRelationship() {
            return relationship;
        }

        public String getForumSign() {
            return forumSign;
        }

        public String getAbout() {
            return about;
        }

        public String getLikeToMeet() {
            return likeToMeet;
        }

        public String getMovies() {
            return movies;
        }

        public String getInterests() {
            return interests;
        }

        public String getMusic() {
            return music;
        }

        public String getSmoker() {
            return smoker;
        }

        public String getDrinker() {
            return drinker;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", diaplayName='" + diaplayName + '\'' +
                    ", email='" + email + '\'' +
                    ", gender='" + gender + '\'' +
                    ", profilePhoto='" + profilePhoto + '\'' +
                    ", coverPhoto='" + coverPhoto + '\'' +
                    ", creditPoints='" + creditPoints + '\'' +
                    ", referralCode='" + referralCode + '\'' +
                    ", location='" + location + '\'' +
                    ", city='" + city + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", relationship='" + relationship + '\'' +
                    ", forumSign='" + forumSign + '\'' +
                    ", about='" + about + '\'' +
                    ", likeToMeet='" + likeToMeet + '\'' +
                    ", movies='" + movies + '\'' +
                    ", interests='" + interests + '\'' +
                    ", music='" + music + '\'' +
                    ", smoker='" + smoker + '\'' +
                    ", drinker='" + drinker + '\'' +
                    '}';
        }

        public String getString(String key) {
            switch (key) {
                case "location":
                    return getLocation();
                case "city":
                    return getCity();
                case "zipcode":
                    return getZipCode();
                case "relationship":
                    return getRelationship();
                case "about_me":
                    return getAbout();
                case "i_like_to_meet":
                    return getLikeToMeet();
                case "movies":
                    return getMovies();
                case "interests":
                    return getInterests();
                case "music":
                    return getMusic();
                case "smoker":
                    return getSmoker();
                case "drinker":
                    return getDrinker();
            }
            return "";
        }
    }

    public class UserListElement {
        @SerializedName("User")
        User userDetail;

        public User getUserDetail() {
            return userDetail;
        }

        @Override
        public String toString() {
            return "UserListElement{" +
                    "userDetail=" + userDetail +
                    '}';
        }
    }

    public class ImageListElement {
        @SerializedName("Profileimage")
        ProfileImage profileImage;

        public ProfileImage getProfileImage() {
            return profileImage;
        }

        @Override
        public String toString() {
            return "ImageListElement{" +
                    "profileImage=" + profileImage +
                    '}';
        }
    }

    public class ProfileImage {
        @SerializedName("id")
        String imageID;
        @SerializedName("user_name")
        String userName;

        public String getImageID() {
            return imageID;
        }

        public void setImageID(String imageID) {
            this.imageID = imageID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "ProfileImage{" +
                    "imageID='" + imageID + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }

}
