package app.rockkworld.adapters;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.transition.TransitionInflater;
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
import app.rockkworld.fragments.BaseFragment;
import app.rockkworld.fragments.ImageViewerFragment;
import app.rockkworld.models.UserPost;
import app.rockkworld.models.UserPost;
import app.rockkworld.utils.APIs;
import app.rockkworld.utils.MLog;
import app.rockkworld.utils.TestUtils;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by divya on 30/8/15.
 */
public class PostsAdapter extends ArrayAdapter<UserPost> implements View.OnClickListener {
    private Context context;
    private BaseFragment fragment;

    public PostsAdapter(BaseFragment fragment, int resource, List<UserPost> objects) {
        super(fragment.mActivty, resource, objects);
//        this.context = context;
        this.fragment = fragment;
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
            postViewHolder.postImg.setOnClickListener(this);

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


        postViewHolder.doComment.setTag(R.id.listtuple_position, position);
        postViewHolder.postImg.setTag(position);
        postViewHolder.doLike .setTag(R.id.listtuple_position, position);
        postViewHolder.doDislike .setTag(R.id.listtuple_position, position);
        postViewHolder.doShare.setTag(R.id.listtuple_position,position);
        postViewHolder.likeCount.setTag( position);
        postViewHolder.dislikeCount.setTag(position);
        postViewHolder.commentCount.setTag(position);

        return convertView;
    }


    @Override
    public void onClick(View v) {
        if (v.getTag() == null) {
            return;
        }
        int position = Integer.parseInt(v.getTag().toString());
        switch (v.getId()) {
            case R.id.tuple_postImage:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    v.setTransitionName("image_post" + position);
                    Activity mActivty = fragment.mActivty;
//                    fragment.setSharedElementReturnTransition(TransitionInflater.from(mActivty).inflateTransition(R.transition.change_image_transform));
                    fragment.setSharedElementReturnTransition(TransitionInflater.from(mActivty).inflateTransition(R.transition.change_image_transform));
                    fragment.setExitTransition(TransitionInflater.from(mActivty).inflateTransition(android.R.transition.fade));
//                    fragment.setReturnTransition(TransitionInflater.from(mActivty).inflateTransition(android.R.transition.explode));

                    // Create new fragment to add (Fragment B)
                    BaseFragment fragment = ImageViewerFragment.getInstance(APIs.URL_GetPostImage(getItem(position).getPostImage()), v.getTransitionName());
                    fragment.setSharedElementEnterTransition(TransitionInflater.from(mActivty).inflateTransition(R.transition.change_image_transform));
                    fragment.setEnterTransition(TransitionInflater.from(mActivty).inflateTransition(android.R.transition.fade));
//                    fragment.setReenterTransition(TransitionInflater.from(mActivty).inflateTransition(android.R.transition.explode));
                    // Our shared element (in Fragment A)
//                    mProductImage   = (ImageView) mLayout.findViewById(R.id.product_detail_image);

                    // Add Fragment B
                    FragmentTransaction ft = this.fragment.getFragmentManager().beginTransaction()
                            .addSharedElement(v, v.getTransitionName())
                            .replace(R.id.rw_fragmentContainer, fragment)
                            .addToBackStack("transaction")
                            ;
                    ft.commit();
                }
                break;
        }

//        try {
//
//            int postiion= (int) v.getTag();
//            String clickedView="";
//            UserPost UserPost = getItem(postiion);
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
//                    UserPost.setLikeCount(!UserPost.getLikeCount());
//                    v.setSelected(UserPost.getLikeCount());
////                    UserPost.setLikeCount(UserPost.getLikeCount());
//                    break;
//                case R.id.do_dislikes:
//                    clickedView="do_dislikes";
//                    UserPost.setDislikeStatus(!UserPost.getDislikeStatus());
//                    v.setSelected(UserPost.getDislikeStatus());
////                    UserPost.setDislikeCount(UserPost.getDislikeCount()+1);
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
