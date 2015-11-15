package app.rockkworld.network;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * Created by divya on 6/7/15.
 */
public class MRequest<T extends ResponseMetadata> extends Request<T> {

    private Priority mPriority = Priority.NORMAL;
    private ResponseListner mListener;
    private Class<T> mClass;
//    private Context mContext;
    private Type mType;

    public MRequest( String url, ResponseListner responseListner, Class<T> mClass) {
        super(Method.POST, url, null);
//        this.mContext = mContext;
        mListener = responseListner;
        this.mClass = mClass;
    }

    public Context getContext() {
        return null;//mContext;
    }

    @Override
    protected void deliverResponse(T response) {
        try {
            if ((null != response) && (response instanceof ResponseMetadata)) {
                mListener.onResponse(this, response);
            }
        } catch (Exception e) {
        }

    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {


        try {

            String json = changeData(response);
            System.out.println("============" + getUrl());

            Response<T> success = Response.success(new GsonBuilder().create().fromJson(json, mClass), HttpHeaderParser.parseCacheHeaders(response));
            if (success != null) {
                Response.error(new NullResponseError());
            }
            return success;
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e) {
            System.out.println(mClass + ": " + e);
            return Response.error(new VolleyError(e));
        }
    }

    private String changeData(NetworkResponse response) throws UnsupportedEncodingException {


        String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers)).trim();
        System.out.println(getUrl());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(json);
        return json;

    }


    public Object getTaskId() {
        return null;
    }
}
