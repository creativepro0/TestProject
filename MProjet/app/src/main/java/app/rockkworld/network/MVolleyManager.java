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

	private static RequestQueue mRequestQueue;
	private static ImageLoader mImageLoader;

	private MVolleyManager(Context context) {
		init(context);
	}

	private static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache());
	}

	private static RequestQueue getRequestQueue(Context context) {
		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			// throw new IllegalStateException("RequestQueue not initialized");
			init(context);

			return mRequestQueue;
		}
	}

	public static ImageLoader getImageLoader(Context context) {
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(getRequestQueue(context), new LruBitmapCache());

		}
		return mImageLoader;
	}

	public static void addToQueue(MRequest<?> nacresRequest) {
		getRequestQueue(nacresRequest.getContext()).add(nacresRequest);
	}

	public static void cancelAllByTaskId(Context context, final Object taskId) {

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
	public static void cancelAllByTag(Context context, Object tag) {
		getRequestQueue(context).cancelAll(tag);

	}

	/**
	 * Cancels all requests in this queue with the given url-Prefix. Tag must be
	 * non-null and equality is by identity.
	 */
	public static void cancelAllByUrlPrefix(Context context, final String taskId) {
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
	public static void cancelAll(Context context) {
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
	public static void cancelRequest(Context context, final Request<?> nacresRequest) {
		getRequestQueue(context).cancelAll(new RequestFilter() {
			@Override
			public boolean apply(Request<?> request) {
				return request.equals(nacresRequest);
			}
		});
	}
}
