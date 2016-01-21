package app.rockkworld.adapters;

import android.widget.AbsListView;

import java.util.AbstractList;

/**
 * * 7/11/15.
 */
public abstract class EndlessRecyclerForLiveFeedOnScrollListener implements AbsListView.OnScrollListener {
    public static String TAG = EndlessRecyclerForLiveFeedOnScrollListener.class.getSimpleName();

    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 2; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private String current_page = null;

    public void resetPage() {
        firstVisibleItem = visibleItemCount = totalItemCount = previousTotal = 0;
        loading = true;
        current_page = null;
    }

    public void setLastItem(String id) {
        current_page = id;
    }

    public abstract void onLoadMore(String id);

    public abstract void updateLastItem(EndlessRecyclerForLiveFeedOnScrollListener scrollListener,AbsListView absListView, int position);


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        this.totalItemCount = totalItemCount;
        this.firstVisibleItem = firstVisibleItem;

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                updateLastItem(this,view, totalItemCount - 1);
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached
            // Do something
            onLoadMore(current_page);
            loading = true;
        }
    }
}
