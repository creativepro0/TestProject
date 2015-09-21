package app.rockkworld.com.mproject.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Hashtable;
import java.util.List;

import app.rockkworld.R;
import app.rockkworld.com.mproject.dialogs.CommentDialog;
import app.rockkworld.com.mproject.dialogs.LikeDisLikeDialog;
import app.rockkworld.com.mproject.model.UserMetaDetail;
import app.rockkworld.com.mproject.model.UserPost;
import app.rockkworld.com.mproject.utils.MLog;
import app.rockkworld.com.mproject.utils.TestUtils;

/**
 * Created by divya on 30/8/15.
 */
public class PostsAdapter extends ArrayAdapter<UserPost> implements View.OnClickListener {
    private Context context;
    private Hashtable<String, UserMetaDetail> userMap;

    public PostsAdapter(Context context, int resource, List<UserPost> objects, Hashtable<String, UserMetaDetail> userMap) {
        super(context, resource, objects);
        this.context = context;
        this.userMap = userMap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostViewHolder postViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_image, null);
            postViewHolder = new PostViewHolder();
            postViewHolder.userName = (TextView) convertView.findViewById(R.id.txtUserName);
            postViewHolder.timeStamp = (TextView) convertView.findViewById(R.id.txtPostTime);

            postViewHolder.likeCount = (TextView) convertView.findViewById(R.id.txt_likeCount);
            postViewHolder.likeCount.setOnClickListener(this);

            postViewHolder.dislikeCount = (TextView) convertView.findViewById(R.id.txt_dislikeCount);
            postViewHolder.dislikeCount.setOnClickListener(this);

            postViewHolder.commentCount = (TextView) convertView.findViewById(R.id.txt_commentCount);
            postViewHolder.commentCount.setOnClickListener(this);

            postViewHolder.postText = (TextView) convertView.findViewById(R.id.post_text);
            postViewHolder.userImg = (ImageView) convertView.findViewById(R.id.userImg);
            postViewHolder.postImg = (ImageView) convertView.findViewById(R.id.post_image);

            postViewHolder.doComment = (TextView) convertView.findViewById(R.id.do_comment);
            postViewHolder.doComment.setOnClickListener(this);

            postViewHolder.doLike = (TextView) convertView.findViewById(R.id.do_likes);
            postViewHolder.doLike.setOnClickListener(this);

            postViewHolder.doDislike = (TextView) convertView.findViewById(R.id.do_dislikes);
            postViewHolder.doDislike.setOnClickListener(this);

            postViewHolder.doShare = (TextView) convertView.findViewById(R.id.do_share);
            postViewHolder.doShare.setOnClickListener(this);


            convertView.setTag(postViewHolder);
        } else {
            postViewHolder = (PostViewHolder) convertView.getTag();
        }
        UserPost item = getItem(position);
        String uid = item.getUid();
        UserMetaDetail userMetaDetail = userMap.get(uid);
        postViewHolder.userName.setText(userMetaDetail.getName());
        postViewHolder.userImg.setImageResource(TestUtils.getUserDpResourse(userMetaDetail.getDp()));
        postViewHolder.timeStamp.setText(item.getTimeStamp());

        postViewHolder.likeCount.setText("Likes "+item.getLikeCount());
        postViewHolder.dislikeCount.setText("Dislikes "+item.getDislikeCount());
        postViewHolder.commentCount.setText("Comments "+item.getCommentsCount());

        MLog.d("msg[" + position + "]= " + item.getMsg());
        if (!TextUtils.isEmpty(item.getMsg())) {
            postViewHolder.postText.setVisibility(View.VISIBLE);
            postViewHolder.postText.setText(item.getMsg());
        } else {
            postViewHolder.postText.setVisibility(View.GONE);
        }
        if (item.getImgs() != null) {
            postViewHolder.postImg.setImageResource(TestUtils.getImageResourse(item.getImgs().get(0)));
            postViewHolder.postImg.setVisibility(View.VISIBLE);
        } else {
            postViewHolder.postImg.setVisibility(View.GONE);
        }

        postViewHolder.doLike .setSelected(item.getLikeStatus());
        postViewHolder.doDislike .setSelected(item.getDislikeStatus());


        postViewHolder.doComment.setTag(position);
        postViewHolder.doLike .setTag(position);
        postViewHolder.doDislike .setTag(position);
        postViewHolder.doShare.setTag(position);

        postViewHolder.likeCount.setTag( position);
        postViewHolder.dislikeCount.setTag(position);
        postViewHolder.commentCount.setTag(position);

        return convertView;
    }


    @Override
    public void onClick(View v) {

        try {

            int postiion= (int) v.getTag();
            String clickedView="";
            UserPost userPost = getItem(postiion);
            switch (v.getId()){
                case R.id.do_comment:
                    clickedView="do_comment";
                    CommentDialog dialog=new CommentDialog(context,null);
                    dialog.show();
                    break;
                case R.id.do_share:
                    clickedView="do_share";

                    break;
                case R.id.do_likes:
                    clickedView="do_likes";
                    userPost.setLikeStatus(!userPost.getLikeStatus());
                    v.setSelected(userPost.getLikeStatus());
//                    userPost.setLikeCount(userPost.getLikeCount());
                    break;
                case R.id.do_dislikes:
                    clickedView="do_dislikes";
                    userPost.setDislikeStatus(!userPost.getDislikeStatus());
                    v.setSelected(userPost.getDislikeStatus());
//                    userPost.setDislikeCount(userPost.getDislikeCount()+1);
                    break;

                case R.id.txt_commentCount:
                    clickedView="txt_commentCount";
                    CommentDialog dialog1=new CommentDialog(context,null);
                    dialog1.show();
                    break;
                case R.id.txt_dislikeCount:
                    clickedView="txt_dislikeCount";
                    LikeDisLikeDialog dialog2=new LikeDisLikeDialog(context);
                    dialog2.show();
                    break;
                case R.id.txt_likeCount:
                    clickedView="txt_likeCount";
                    LikeDisLikeDialog dialog3=new LikeDisLikeDialog(context);
                    dialog3.show();
                    break;

            }
//            Toast.makeText(context,clickedView+" @ "+postiion,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
          e.printStackTrace();
        }

    }

    public static class PostViewHolder {

        ImageView postImg;
        TextView postText;
        TextView likeCount;
        TextView commentCount;
        TextView dislikeCount;
        TextView timeStamp;

        TextView userName;
        ImageView userImg;

        TextView doComment;
        TextView doLike;
        TextView doDislike;
        TextView doShare;
    }
}
