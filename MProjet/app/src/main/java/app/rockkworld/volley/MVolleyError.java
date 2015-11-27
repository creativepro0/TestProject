package app.rockkworld.volley;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import app.rockkworld.utils.Constants;

/**
 * Created by vipul on 25/6/15.
 */
public class MVolleyError extends com.android.volley.VolleyError {

    public String getErrorMessage(com.android.volley.VolleyError error){

        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            return Constants.CONNECTION_TIMEOUT;
        } else if (error instanceof ServerError) {
            return Constants.SERVER_ERROR;
        } else if (error instanceof NetworkError) {
            return Constants.SERVER_ERROR;

        } else if (error instanceof ParseError) {
            return Constants.APPLICATION_ERROR;

        }else{
            return Constants.SERVER_ERROR;
        }

    }

}
