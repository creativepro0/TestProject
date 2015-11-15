package app.rockkworld.network;

import com.android.volley.VolleyError;

/**
 * Created by divya on 15/11/15.
 */
public interface ResponseListner<T> {

    void onResponse(MRequest request, T response);
    void onErrorResponse(MRequest request, VolleyError error);
}
