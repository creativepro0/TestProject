package app.rockkworld.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.Hashtable;
import java.util.List;

import app.rockkworld.R;
import app.rockkworld.models.UserPost;
import app.rockkworld.models.UserPostRoot;
import app.rockkworld.utils.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.utils.TestUtils;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by divya on 30/8/15.
 */
public class PostsAdapter extends ArrayAdapter<UserPostRoot> implements View.OnClickListener {
    private Context context;

    public PostsAdapter(Context context, int resource, List<UserPostRoot> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostViewHolder postViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tuple_newfeed, null);
            postViewHolder = new PostViewHolder();
            postViewHolder.userImg = (NetworkImageView) convertView.findViewById(R.id.iv_tuple_userPic);
            postViewHolder.userName = (TextView) convertView.findViewById(R.id.tuple_userName);
            postViewHolder.timeStamp = (TextView) convertView.findViewById(R.id.tuple_postTime);

            postViewHolder.likeCount = (TextView) convertView.findViewById(R.id.tuple_countLike);
            postViewHolder.likeCount.setOnClickListener(this);

            postViewHolder.dislikeCount = (TextView) convertView.findViewById(R.id.tuple_countDislikes);
            postViewHolder.dislikeCount.setOnClickListener(this);

            postViewHolder.commentCount = (TextView) convertView.findViewById(R.id.tuple_countComment);
            postViewHolder.commentCount.setOnClickListener(this);

            postViewHolder.shareCount = (TextView) convertView.findViewById(R.id.tuple_countShare);
            postViewHolder.shareCount.setOnClickListener(this);

            postViewHolder.postText = (TextView) convertView.findViewById(R.id.tuple_postText);
            postViewHolder.postImg = (NetworkImageView) convertView.findViewById(R.id.tuple_postImage);

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
        UserPost item = getItem(position).getPost();
//        String uid = item.getUid();
//        UserMetaDetail userMetaDetail = userMap.get(uid);
        postViewHolder.userName.setText(item.getDisplayName());
        MLog.d("item[" + position + "]--->>  " + item);
        if (!TextUtils.isEmpty(item.getProfilePic())) {
            postViewHolder.userImg.setImageUrl(APIs.URL_GetUserImage(item.getProfilePic()), VolleyManager.getImageLoader());
        }else{
            postViewHolder.userImg.setDefaultImageResId(R.drawable.ic_default_profile_pic);
        }
        postViewHolder.timeStamp.setText(item.getModified());

        if(!TextUtils.isEmpty(item.getLikeCount())){
            postViewHolder.likeCount.setText(item.getLikeCount()+" Likes" );
            postViewHolder.likeCount.setVisibility(View.VISIBLE);
        }

        if(!TextUtils.isEmpty(item.getCommentsCount())){
            postViewHolder.commentCount.setText(item.getCommentsCount()+" Comments");
            postViewHolder.commentCount.setVisibility(View.VISIBLE);
        }

        if(item.getSharedBy()!=null){
            postViewHolder.likeCount.setText(item.getSharedBy().size()+" Shares");
            postViewHolder.likeCount.setVisibility(View.VISIBLE);
        }

        MLog.d("msg[" + position + "]= " + item.getPostText());
        if (!TextUtils.isEmpty(item.getPostText())) {
            postViewHolder.postText.setVisibility(View.VISIBLE);
            postViewHolder.postText.setText(item.getPostText());
        } else {
            postViewHolder.postText.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(item.getPostImage())) {
            MLog.d("getPostImage",APIs.URL_GetPostImage(item.getPostImage()));
            postViewHolder.postImg.setImageUrl(APIs.URL_GetPostImage(item.getPostImage()), VolleyManager.getImageLoader());
            postViewHolder.postImg.setVisibility(View.VISIBLE);
        } else {
            postViewHolder.postImg.setVisibility(View.GONE);
        }

        postViewHolder.doLike .setSelected(!TextUtils.isEmpty(item.getLikeUnlikeBySelf()));
        postViewHolder.doDislike .setSelected(!TextUtils.isEmpty(item.getLikeUnlikeBySelf()));


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

//        try {
//
//            int postiion= (int) v.getTag();
//            String clickedView="";
//            UserPostRoot UserPostRoot = getItem(postiion);
//            switch (v.getId()){
//                case R.id.do_comment:
//                    clickedView="do_comment";
//                    CommentDialog dialog=new CommentDialog(context,null);
//                    dialog.show();
//                    break;
//                case R.id.do_share:
//                    clickedView="do_share";
//
//                    break;
//                case R.id.do_likes:
//                    clickedView="do_likes";
//                    UserPostRoot.setLikeCount(!UserPostRoot.getLikeCount());
//                    v.setSelected(UserPostRoot.getLikeCount());
////                    UserPostRoot.setLikeCount(UserPostRoot.getLikeCount());
//                    break;
//                case R.id.do_dislikes:
//                    clickedView="do_dislikes";
//                    UserPostRoot.setDislikeStatus(!UserPostRoot.getDislikeStatus());
//                    v.setSelected(UserPostRoot.getDislikeStatus());
////                    UserPostRoot.setDislikeCount(UserPostRoot.getDislikeCount()+1);
//                    break;
//
//                case R.id.txt_commentCount:
//                    clickedView="txt_commentCount";
//                    CommentDialog dialog1=new CommentDialog(context,null);
//                    dialog1.show();
//                    break;
//                case R.id.txt_dislikeCount:
//                    clickedView="txt_dislikeCount";
//                    LikeDisLikeDialog dialog2=new LikeDisLikeDialog(context);
//                    dialog2.show();
//                    break;
//                case R.id.txt_likeCount:
//                    clickedView="txt_likeCount";
//                    LikeDisLikeDialog dialog3=new LikeDisLikeDialog(context);
//                    dialog3.show();
//                    break;
//
//            }
////            Toast.makeText(context,clickedView+" @ "+postiion,Toast.LENGTH_SHORT).show();
//        }catch (Exception e){
//          e.printStackTrace();
//        }

    }

    public static class PostViewHolder {

        NetworkImageView postImg;
        TextView postText;
        TextView likeCount;
        TextView commentCount;
        TextView shareCount;
        TextView dislikeCount;
        TextView timeStamp;

        TextView userName;
        NetworkImageView userImg;

        TextView doComment;
        TextView doLike;
        TextView doDislike;
        TextView doShare;
    }
}
