package app.rockkworld.volley;

import com.android.volley.Response;

/**
 * Created by divya on 6/7/15.
 */
public class MGetGsonRequest extends MRequest {

    public MGetGsonRequest(String url, Response.ErrorListener listener) {
        super(Method.GET,url, listener);
    }
}
