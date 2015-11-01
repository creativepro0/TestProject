package app.rockkworld.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by divya on 10/8/15.
 */
public class UserMetaDetail implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("uid")
    private String uid;

    @SerializedName("dp")
    private String dp;

    @SerializedName("ts")
    private String ts;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    @Override
    public String toString() {
        return "UserMetaDetail{" +
                "name='" + name + '\'' +
                ", dp='" + dp + '\'' +
                '}';
    }
}
