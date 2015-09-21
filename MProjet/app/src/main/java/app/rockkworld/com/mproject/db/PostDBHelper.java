package app.rockkworld.com.mproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by divya on 30/8/15.
 */
public class PostDBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME="RockkworldDB";
    private final static int DATABASE_VERSION=1;


    public PostDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
