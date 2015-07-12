package app.rockkworld.com.mproject.volley;

import com.android.volley.Response;

/**
 * Created by divya on 6/7/15.
 */
public class MPostGsonRequest extends MRequest {
    public MPostGsonRequest(String url, Response.ErrorListener listener) {
        super(Method.POST,url, listener);
    }
}
