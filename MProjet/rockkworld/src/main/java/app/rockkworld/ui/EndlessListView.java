package app.rockkworld.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by divya on 1/1/16.
 */
public class EndlessListView extends ListView implements AbsListView.OnScrollListener {

    public EndlessListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {}

}
