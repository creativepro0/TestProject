
package app.rockkworld.network;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;

import app.rockkworld.utils.MLog;

/**
 * Created by Divya on 17/7/15.
 */
public class MRetryPolicy extends DefaultRetryPolicy {

    private final String CLASS_TAG=getClass().getName();

    public MRetryPolicy(int initialTimeoutMs, int aMaxNumRetries, float aBackoffMultiplier) { /* compiled code */
        super(initialTimeoutMs,aMaxNumRetries,aBackoffMultiplier);
    }

    @Override
    public void retry(VolleyError error) throws VolleyError {
        MLog.d(CLASS_TAG, "::" + error);
        super.retry(error);
    }

    @Override
    public int getCurrentTimeout() {
        MLog.d(CLASS_TAG, "============TimeOut");
        //  getCurrentRetryCount();
        return  super.getCurrentTimeout();
    }

    @Override
    public int getCurrentRetryCount() {


    /* compiled code */
        int count=super.getCurrentRetryCount();
        MLog.d(CLASS_TAG, "============CurrentRetryCount  :  " + count);
        return  count;

    }



}
