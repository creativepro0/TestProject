package app.rockkworld.volley;

import com.android.volley.Response;

/**
 * Created by divya on 6/7/15.
 */
public class MPutGsonRequest extends MRequest {
    public MPutGsonRequest(String url, Response.ErrorListener listener) {
        super(Method.PUT,url, listener);
    }
}
