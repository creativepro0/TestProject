package app.rockkworld.com.mproject.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by divya on 6/7/15.
 */
public class MRequest<T extends ResponseMetadata> extends Request<T> {

    private Class<T> mClass;

    public MRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }


    @Override
    protected void deliverResponse(T response) {

    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {


        try {

            String json=changeData(response);
            System.out.println("============"+getUrl());

            Response<T> success = Response.success(new GsonBuilder().create().fromJson(json, mClass), HttpHeaderParser.parseCacheHeaders(response));
            if (success!=null) {
                Response.error(new NullResponseError());
            }
            return success;
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }catch (Exception e) {
            System.out.println(mClass+": "+e);
            return Response.error(new VolleyError(e));
        }
    }

    private String changeData(NetworkResponse response) throws UnsupportedEncodingException{


        String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers)).trim();
        System.out.println(getUrl());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(json);
        return json;

    }


}
