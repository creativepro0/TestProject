package app.rockkworld.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by divya on 13/10/15.
 */
public class APIs {
    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_Splash() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams email, password
     * @ReponseItems OauthKey:String,UserInfo{uid:String,name:String,creditPoint:int},
     */
    public static String URL_Login() {
        return "http://rockkworld.com/webservice/cust_login.php";
    }

    /**
     * @Method POST
     * @apiParams
     * @ReponseItems OauthKey:String,UserInfo{uid:String,name:String,creditPoint:int},
     */
    public static String URL_Register() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams OauthKey, Uid
     * @ReponseItems msg:String,
     */
    public static String URL_Logout() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams email
     * @ReponseItems msg:String
     */
    public static String URL_ForgotPassword() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams profileId, page
     */
    public static String URL_NewFeed(HashMap<String, String> params) {
        String url = "http://www.rockkworld.com/Mobile/newsfeeddata?";
        if (params != null) {
            Set<String> paramKeys = params.keySet();
            Iterator<String> iterator = paramKeys.iterator();
            while (iterator.hasNext()){
                String paramS=iterator.next();
                paramS+= "="+params.get(paramS);
                url+=paramS+"&";
            }
        }
        return url;
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_UserProfile() {
        return "http://www.rockkworld.com/Mobile/profileDetail?own_name=rakesh.7&user_name=rakesh.7";//own_name=jiya.178&user_name=monika.119";
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_GetLikes() {
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_SendLike() {
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_GetDisLikes() {
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_SendDisLike() {
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_GetComments() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_SendComment() {
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_Share() {
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_GetPostImage(String imgId) {
        return "http://rockkworld.com/img/userpost/big/" + imgId;
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_GetUserImage(String imgId) {
        return "http://rockkworld.com/img/profilephoto/small/" + imgId;
    }

    /**
     * @Method POST
     * @apiParams
     */
    public static String URL_CreditPointData() {
        return "";
    }


}
