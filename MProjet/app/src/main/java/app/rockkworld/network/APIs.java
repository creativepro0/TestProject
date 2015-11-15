package app.rockkworld.network;

/**
 * Created by divya on 13/10/15.
 */
public class APIs {
    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_Splash(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams email,password
     * @ReponseItems OauthKey:String,UserInfo{uid:String,name:String,creditPoint:int},
     */
    public static String URL_Login(){
        return "rockkworld.com/webservice/cust_login.php";
    }

    /**
     * @Method POST
     * @apiParams
     * @ReponseItems OauthKey:String,UserInfo{uid:String,name:String,creditPoint:int},
     */
    public static String URL_Register(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams OauthKey,Uid
     * @ReponseItems msg:String,
     */
    public static String URL_Logout(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams email
     * @ReponseItems msg:String
     */
    public static String URL_ForgotPassword(){
        return "";
    }
    /**
     * @Method POST
     * @apiParams uid:String,lastFetchedPostID:String
     *
     */
    public static String URL_NewFeed(){
        return "http://rockkworld.com/webservice/news-feed.php";
    }

    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_UserProfile(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_GetLikes(){
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_SendLike(){
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_GetDisLikes(){
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_SendDisLike(){
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_GetComments(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_SendComment(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_Share(){
        return "";
    }


    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_GetPostImage(){
        return "";
    }
    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_GetUserImage(){
        return "";
    }

    /**
     * @Method POST
     * @apiParams
     *
     */
    public static String URL_CreditPointData(){
        return "";
    }


}
