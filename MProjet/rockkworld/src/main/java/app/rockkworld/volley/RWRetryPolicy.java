
package app.rockkworld.volley;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;

/**
 * Created by neha on 26/2/15.
 */
public class RWRetryPolicy extends DefaultRetryPolicy {



    public RWRetryPolicy(int initialTimeoutMs, int aMaxNumRetries, float aBackoffMultiplier) { /* compiled code */

        super(initialTimeoutMs,aMaxNumRetries,aBackoffMultiplier);

    }

    @Override
    public void retry(VolleyError error) throws VolleyError {
        System.out.println("::"+error);
        super.retry(error);

    }

    @Override
    public int getCurrentTimeout() {
        System.out.println("============TimeOut");
        //  getCurrentRetryCount();
        return  super.getCurrentTimeout();
    }

    @Override
    public int getCurrentRetryCount() {


    /* compiled code */
        int count=super.getCurrentRetryCount();
        System.out.println("============CurrentRetryCount  :  "+count);
        return  count;

    }



}
