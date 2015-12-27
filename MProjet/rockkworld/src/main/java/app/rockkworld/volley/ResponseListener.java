package app.rockkworld.volley;

import com.android.volley.VolleyError;

/**
 * @author gaurav
 * 
 * @param <T>
 *            : Response Object
 */
public interface ResponseListener<T> {

	/**
	 *
	 * @param request
	 *            :Request of resulting response
	 * @param response
	 *            :Final Response When correct response will occur
	 */
	void onResponse(RWRequest<T> request, T response);

	/**
	 * @param request
	 *            :Request of resulting response
	 * @param error
	 *            :VolleyError When an error will occur
	 * 
	 *            ::Type of Error 
	 *            >>TimeoutError 
	 *            >>ServerError 
	 *            >>ParseError 
	 *            >>NetworkError => NoConnectionError 
	 *            >>AuthFailureError
	 * 
	 */
	void onErrorResponse(RWRequest<T> request, VolleyError error);

}