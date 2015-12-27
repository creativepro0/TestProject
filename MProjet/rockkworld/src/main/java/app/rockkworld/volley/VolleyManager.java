package app.rockkworld.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleyManager {

	private static RequestQueue mRequestQueue;
	private static ImageLoader mImageLoader;

	private VolleyManager(Context context) {
		init(context);
	}


	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache());
	}

    public static RequestQueue getRequestQueue(){
        return mRequestQueue;
	}

	public static ImageLoader getImageLoader() {
		return mImageLoader;
	}


	public static void addToQueue(RWRequest<?> nacresRequest) {
		mRequestQueue.add(nacresRequest);
	}

	public static void cancelAllByTaskId(Context context, final Object taskId) {

		//@Ashish Saini --patch to handle Class cast exception due to ImageRequest type of request

//		try {
//			if (taskId == null) {
//				throw new IllegalArgumentException("Cannot cancelAll with a null taskId");
//			}
//			getRequestQueue(context).cancelAll(new RequestFilter() {
//				@Override
//				public boolean apply(Request<?> request) {
//
//					return taskId.equals(((RWRequest<?>) request).getTaskId());
//				}
//			});
//		}
//		catch (ClassCastException e){
//			e.printStackTrace();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}

	}

	public static void cancelAllByTag(Context context, Object tag) {
//		getRequestQueue(context).cancelAll(tag);

	}

	public static void cancelAllByUrlPrefix(Context context, final String taskId) {
//		if (taskId == null) {
//			throw new IllegalArgumentException("Cannot cancelAll with a null url-Prefix");
//		}
//		getRequestQueue(context).cancelAll(new RequestFilter() {
//			@Override
//			public boolean apply(Request<?> request) {
//
//				return ((RWRequest<?>) request).getUrl().startsWith(taskId);
//			}
//		});
	}

	public static void cancelAll(Context context) {
//		getRequestQueue(context).cancelAll(new RequestFilter() {
//			@Override
//			public boolean apply(Request<?> request) {
//				return true;
//			}
//		});
	}

	public static void cancelRequest(Context context, final Request<?> nacresRequest) {
//		getRequestQueue(context).cancelAll(new RequestFilter() {
//			@Override
//			public boolean apply(Request<?> request) {
//				return request.equals(nacresRequest);
//			}
//		});
	}
}
