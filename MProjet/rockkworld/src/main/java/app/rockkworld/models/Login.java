package app.rockkworld.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by divya on 9/11/15.
 */
public class Login {

    @SerializedName("status")
    String status;

    @SerializedName("accessToken")
    String accessToken;
    @SerializedName("result")
    LoginResult loginLoginResult;

    @Override
    public String toString() {
        return "Login{" +
                "status='" + status + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", loginLoginResult=" + loginLoginResult +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LoginResult getLoginLoginResult() {
        return loginLoginResult;
    }

    public void setLoginLoginResult(LoginResult loginLoginResult) {
        this.loginLoginResult = loginLoginResult;
    }

    public class LoginResult {

        @SerializedName("deviceInfo")
        String deviceInfo;
        @SerializedName("uid")
        String uid;
        @SerializedName("dname")
        String dName;
        @SerializedName("dpic")
        String dPic;

        @Override
        public String toString() {
            return "LoginResult{" +
                    "deviceInfo='" + deviceInfo + '\'' +
                    ", uid='" + uid + '\'' +
                    ", dName='" + dName + '\'' +
                    ", dPic='" + dPic + '\'' +
                    '}';
        }

        public String getDeviceInfo() {
            return deviceInfo;
        }

        public void setDeviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getdName() {
            return dName;
        }

        public void setdName(String dName) {
            this.dName = dName;
        }

        public String getdPic() {
            return dPic;
        }

        public void setdPic(String dPic) {
            this.dPic = dPic;
        }
    }
}
