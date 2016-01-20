package app.rockkworld.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;

import app.rockkworld.R;
import app.rockkworld.volley.VolleyManager;

/**
 * Created by rohit on 21/1/16.
 */
public class ImageViewerFragment extends BaseFragment {

    public static ImageViewerFragment getInstance(String imgUrl, String tName) {
        ImageViewerFragment imageViewerFragment = new ImageViewerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", imgUrl);
        bundle.putString("tName", imgUrl);
        imageViewerFragment.setArguments(bundle);
        return imageViewerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_image_viewer, null);
        NetworkImageView imageView = (NetworkImageView) inflate.findViewById(R.id.iv_image_full);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return inflate;
        }
        String tName = arguments.getString("tName");
        imageView.setTransitionName(tName);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String url = arguments.getString("url");
        NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.iv_image_full);
        imageView.setImageUrl(url, VolleyManager.getImageLoader());
    }
}
