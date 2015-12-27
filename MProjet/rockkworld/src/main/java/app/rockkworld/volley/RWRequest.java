package app.rockkworld.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class RWRequest<T> extends Request<T> {

    private Priority mPriority = Priority.NORMAL;
    private final Map<String, String> mParams;

    private final ResponseListener<T> mListener;
    private Object mTaskId;
    private boolean debug = true;

    /**
     * @param method
     *            :com.android.volley.Request.Method
     * @param url
     *            :URL
     * @param params
     *            :parameters
     * @param listener
     *            :NNacresResponseListener on which Response callback will occur
     * @param taskId
     *            :this key is for developer purpose it is same like tag
     * @param priority
     *            :Priority of request
     */
    public RWRequest( int method, String url, Map<String, String> params, ResponseListener<T> listener, Object taskId, Priority priority) {
        super(method, url, null);
        this.mListener = listener;
        this.mPriority = priority;
        this.mParams = params;
        this.mTaskId = taskId;

        setRetryPolicy(new RWRetryPolicy(60000,0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        removeNullValuesFromParams();

    }
    /*@Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        retryPolicy=new RetryPolicy() {

        @Override
        public void retry(VolleyError error) throws VolleyError {
            System.out.println("::"+error);
            // TODO Auto-generated method stub

        }

        @Override
        public int getCurrentTimeout() {
            // TODO Auto-generated method stub
            return 30000;//30 sec;
        }

        @Override
        public int getCurrentRetryCount() {
            // TODO Auto-generated method stub
            return 0;
        }
    };
        return(super.setRetryPolicy(retryPolicy));
    }
*/
    private void removeNullValuesFromParams() {
        if (mParams != null) {
            Iterator<String> itr = mParams.keySet().iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                String value = mParams.get(key);
                if (value == null) {
                    itr.remove();
                    if (debug) {
                        System.out.println("This Key is getting Null value : " + key);
                    }
                }

            }

            if (debug) {
                System.out.println("Start===================================================================Start");
                Iterator<String> itr1 = mParams.keySet().iterator();
                String urlParams=null;
                while (itr1.hasNext()) {
                    String key = (String) itr1.next();
                    String value = mParams.get(key);
                    System.out.println(key + " = " + value);
                    if (urlParams==null) {
                        urlParams="?"+key+"="+value;
                    }else {
                        urlParams+="&"+key+"="+value;
                    }



                }
                System.out.println("get url----------------------------------------------------------------------");
                System.out.println(getUrl()+urlParams);
                System.out.println("End===================================================================End");

            }
        }else {
            System.out.println(getUrl());
        }

    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {

        return mParams;
    }

    @Override
    public Priority getPriority() {
        return mPriority;
    }

    public void setPriority(Priority priority) {
        mPriority = priority;
    }

//    @Override
//    public RetryPolicy getRetryPolicy() {
//        System.out.println("==============getRetryPolicy "+getUrl());
//        return super.getRetryPolicy();
//    }
//
//    @Override
//    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
//        defaultRetryPolicy=null;
//        defaultRetryPolicy=null;
//        return super.setRetryPolicy(retryPolicy);
//    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(this, response);
    }

    @Override
    public void deliverError(VolleyError error) {
        mListener.onErrorResponse(this, error);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Error");
        System.out.println(getUrl());
        System.out.println("----------------------------------");
        System.out.println(mParams + "");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Error");
        System.out.println(error);


    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }

        headers.put("User-Agent", "99acres android app useragent");
        headers.put("Accept-Language", "en");

      /*  Map<String, String> superheaders = super.getHeaders();
        MyLog.e("@ASHISH USER SUPER AGENT  ",superheaders.toString());

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-agent", "YOUR_USER_AGENT");

        MyLog.e("@ASHISH GETHEADER ",headers.toString());*/

        return headers;
    }



//    public Context getContext() {
//        return mContext;
//    }
//
//    public void setContext(Context activity) {
//        mContext = activity;
//    }

    public ResponseListener<T> getListener() {
        return mListener;
    }

    public Object getTaskId() {
        return mTaskId;
    }

    public void setTaskId(Object taskId) {
        mTaskId = taskId;
    }



}
