package app.rockkworld.volley;

import com.android.volley.Response;

/**
 * Created by divya on 6/7/15.
 */
public class MDeleteGsonRequest extends MRequest {
    public MDeleteGsonRequest(String url, Response.ErrorListener listener) {
        super(Method.DELETE,url, listener);
    }
}
