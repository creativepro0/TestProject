package app.rockkworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.rockkworld.R;
import app.rockkworld.models.UserComment;
import app.rockkworld.utils.TestUtils;

/**
 * Created by divya on 15/9/15.
 */
public class CommentsAdapter extends ArrayAdapter<UserComment> {
    private final Context context;
    private boolean isLikeDialog;

    public CommentsAdapter(Context context, int resource, List<UserComment> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.isLikeDialog = isLikeDialog;
        ViewHolder viewHolder=null;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.user_list, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            viewHolder.msg.setVisibility(View.VISIBLE);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        UserComment  item = getItem(position);
        viewHolder.ts.setText(item.getCommentTS());
        viewHolder.userName.setText(item.getUserName());
        viewHolder.userImage.setImageResource(TestUtils.getUserDpResourse(item.getUid()));
        viewHolder.msg.setText(item.getCommentMsg());
        return convertView;
    }

    public static class ViewHolder{
        ImageView userImage;
        TextView userName;
        TextView ts;
        TextView msg;
        ViewHolder(View view){
          msg= (TextView) view.findViewById(R.id.commentMsg);
          ts= (TextView) view.findViewById(R.id.commentTS);
          userName= (TextView) view.findViewById(R.id.userName);
          userImage= (ImageView) view.findViewById(R.id.userDP);
        }
    }
}
