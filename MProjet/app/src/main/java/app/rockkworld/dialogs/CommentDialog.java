package app.rockkworld.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.GsonBuilder;

import app.rockkworld.R;
import app.rockkworld.adapters.CommentsAdapter;
import app.rockkworld.model.Comments;
import app.rockkworld.model.UserComment;
import app.rockkworld.model.UserMetaDetail;
import app.rockkworld.utils.PrefUtils;
import app.rockkworld.utils.TestConstants;

/**
 * Created by divya on 16/9/15.
 */
public class CommentDialog extends Dialog implements View.OnClickListener {
    private final Context context;
    private final OnSendCommentListener listener;

    private CommentsAdapter adapter;

    public CommentDialog(Context context, OnSendCommentListener listener) {
        super(context, R.style.DialogTheme);
        this.context = context;
        this.listener = listener;
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        setContentView(R.layout.like_dialog);
        findViewById(R.id.gotolikeParent).setVisibility(View.VISIBLE);
        findViewById(R.id.sendCommentParent).setVisibility(View.VISIBLE);
        ListView listView = (ListView) findViewById(R.id.userListView);

        Comments likeDislikeModel = new GsonBuilder().create().fromJson(TestConstants.RESPONSE_COMMENTS, Comments.class);
        adapter = new CommentsAdapter(context, -1, likeDislikeModel.getUserComments());
        listView.setAdapter(adapter);

        findViewById(R.id.ibtn_nav_likeDialog).setOnClickListener(this);
        findViewById(R.id.sendComment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ibtn_nav_likeDialog) {
            dismiss();
        }
        if (v.getId() == R.id.sendComment) {
            String text = ((EditText) findViewById(R.id.editTxtComment)).getText().toString();
            if (listener != null && !(TextUtils.isEmpty(text))) {
                UserComment userComment = new UserComment();
                UserMetaDetail userDetail = PrefUtils.get().getUserDetail();
                userComment.setUid(userDetail.getUid());
                userComment.setCommentTS("just now");
                userComment.setUserName(userDetail.getName());
                userComment.setId("22");
                userComment.setCommentMsg(text);
                listener.onSendComment(userComment);
            }
        }
    }

    public interface OnSendCommentListener {
        void onSendComment(UserComment comment);
    }
}
