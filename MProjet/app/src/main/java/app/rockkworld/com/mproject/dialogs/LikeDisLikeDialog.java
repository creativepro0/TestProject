package app.rockkworld.com.mproject.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.google.gson.GsonBuilder;

import app.rockkworld.R;
import app.rockkworld.com.mproject.adapters.LikeDislikeAdapter;
import app.rockkworld.com.mproject.model.LikeDislikeModel;
import app.rockkworld.com.mproject.model.UserComment;
import app.rockkworld.com.mproject.utils.TestConstants;

/**
 * Created by divya on 16/9/15.
 */
public class LikeDisLikeDialog extends Dialog {
    private final Context context;

    public LikeDisLikeDialog(Context context) {
        super(context,R.style.DialogTheme);
        this.context = context;
        setContentView(R.layout.like_dialog);
        ListView listView= (ListView) findViewById(R.id.userListView);

        LikeDislikeModel likeDislikeModel=new GsonBuilder().create().fromJson(TestConstants.RSPONSE_LIKES, LikeDislikeModel.class);
        LikeDislikeAdapter adapter=new LikeDislikeAdapter(context,-1,likeDislikeModel.getLikes());
        listView.setAdapter(adapter);

    }

}
