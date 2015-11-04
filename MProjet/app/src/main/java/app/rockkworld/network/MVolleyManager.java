package app.rockkworld.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import app.rockkworld.utils.LruBitmapCache;
/**
 * Created by Divya on 17/7/15.
 * All Http Request must be pass through. This class is manager class to handle
 * all http request
 *
 *
 *
 *
 */
public class MVolleyManager {
    private static MVolleyManager mgr;

    private Context mAppContext;
	private  RequestQueue mRequestQueue;
	private  ImageLoader mImageLoader;

	private MVolleyManager(Context context) {
		init(context);
        mAppContext =context;
	}

    public static MVolleyManager getInstance(Context context){
        mgr=new MVolleyManager(context);
        return mgr;
    }
    public static MVolleyManager getInstance(){
        return mgr;
    }

	private  void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache());
	}

	private  RequestQueue getRequestQueue(Context context) {
		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			init(context);
			return mRequestQueue;
		}
	}

	public  ImageLoader getImageLoader(Context context) {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getRequestQueue(context), new LruBitmapCache());

		}
		return mImageLoader;
	}

	public  void addToQueue(MRequest<?> nacresRequest) {
		getRequestQueue(nacresRequest.getContext()).add(nacresRequest);
	}

	public  void cancelAllByTaskId(Context context, final Object taskId) {

		try {
			if (taskId == null) {
				throw new IllegalArgumentException("Cannot cancelAll with a null taskId");
			}
			getRequestQueue(context).cancelAll(new RequestFilter() {
				@Override
				public boolean apply(Request<?> request) {

					return taskId.equals(((MRequest<?>) request).getTaskId());
				}
			});
		}
		catch (ClassCastException e){
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Cancels all requests in this queue with the given taskId. taskId must be
	 * non-null and equality is by identity.
	 */
	public  void cancelAllByTag(Context context, Object tag) {
		getRequestQueue(context).cancelAll(tag);

	}

	/**
	 * Cancels all requests in this queue with the given url-Prefix. Tag must be
	 * non-null and equality is by identity.
	 */
	public  void cancelAllByUrlPrefix(Context context, final String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Cannot cancelAll with a null url-Prefix");
		}
		getRequestQueue(context).cancelAll(new RequestFilter() {
			@Override
			public boolean apply(Request<?> request) {

				return request.getUrl().startsWith(taskId);
			}
		});
	}

	/**
	 * Cancels all requests in this queue.
	 */
	public  void cancelAll(Context context) {
		getRequestQueue(context).cancelAll(new RequestFilter() {
			@Override
			public boolean apply(Request<?> request) {
				return true;
			}
		});
	}

	/**
	 * Cancels Request in this queue.
	 */
	public  void cancelRequest(Context context, final Request<?> nacresRequest) {
		getRequestQueue(context).cancelAll(new RequestFilter() {
			@Override
			public boolean apply(Request<?> request) {
				return request.equals(nacresRequest);
			}
		});
	}
}
