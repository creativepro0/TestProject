package app.rockkworld.com.mproject.db;

/**
 * Created by divya on 30/8/15.
 */
public interface PostsTableConstants {


    /**
     PostsTable-------
        postID PK [int]
        postedByID [uid int]
        postedByName [uname varchar]
        sharedByID [uid int]
        postedByName [uname varchar]
        imgUL    [url varchar]
        text [varchar]
     */
    String TABLE_POST="tbl_posts";

    String POST_ID = "postID";
    String POSTED_BY_ID = "postedByID";
    String POSTED_BY_NAME = "postedByName";
    String SHAREDBY_ID = "sharedByID";
    String SHARED_BY_NAME = "sharedByName";
    String IMG_URL = "imgURL";
    String POST_TEXT = "psotText";


    String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_POST + "("
            + POST_ID + " INTEGER PRIMARY KEY,"
            + POSTED_BY_ID + " INTEGER ,"
            + POSTED_BY_NAME + " TEXT ,"
            + SHAREDBY_ID  + " INTEGER ,"
            + SHARED_BY_NAME + " TEXT, "
            + IMG_URL + " TEXT, "
            + POST_TEXT + " TEXT, "
            +")";

}
