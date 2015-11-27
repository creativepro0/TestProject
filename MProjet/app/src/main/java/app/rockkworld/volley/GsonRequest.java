package app.rockkworld.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class GsonRequest<T> extends RWRequest<T> {

	private final Class<T> mClazz;

	/**
	 * @param url
	 *            :URL
	 * @param params
	 *            :parameters
	 * @param listener
	 *            :NNacresResponseListener on which Response callback will occur
	 * @param clazz
	 *            :Expecting model class
	 */
	public GsonRequest(String url, Map<String, String> params, ResponseListener<T> listener, Class<T> clazz) {
		this(params==null? Request.Method.GET: Request.Method.POST, url, params, listener, null, clazz, Request.Priority.NORMAL);

      //  setRetryPolicy(new NNacresRetryPolicy(100,3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
	/**
	 * 
	 * 
	 * 
	 *           
	 * @param method
	 *            :com.android.volley.Request.Method
	 * @param url
	 *            :URL
	 * @param params
	 *            :parameters
	 * @param listener
	 *            :NNacresResponseListener on which Response callback will occur
	 * @param clazz
	 *            :Expecting model class
	 */
	public GsonRequest( int method, String url, Map<String, String> params, ResponseListener<T> listener, Class<T> clazz) {
		this(method, url, params, listener, null, clazz, Request.Priority.NORMAL);

	}

	/**
	 * 
	 *           
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
	 * @param clazz
	 *            :Expecting model class
	 */
	public GsonRequest( int method, String url, Map<String, String> params, ResponseListener<T> listener, Object taskId, Class<T> clazz) {
		this(method, url, params, listener, taskId, clazz, Request.Priority.NORMAL);

	}

	/**
	 * 
	 *           
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
	 * @param clazz
	 *            :Expecting model class
	 * @param priority
	 *            :Priority of request
	 */
	public GsonRequest( int method, String url, Map<String, String> params, ResponseListener<T> listener, Object taskId, Class<T> clazz, Request.Priority priority) {
		super(method, url, params, listener, taskId, priority);
		this.mClazz = clazz;

	}

	@Override
	protected void deliverResponse(T response) {
        super.deliverResponse(response);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(response);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {


        try {

			Map<String, String> responseHeaders = response.headers;

			String json=changeData(response);
            System.out.println("============"+getUrl());

			Response<T> success = Response.success(new GsonBuilder().create().fromJson(json, mClazz), HttpHeaderParser.parseCacheHeaders(response));
			if (success!=null) {
				Response.error(new NullResponseError());
			}
			return success;
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}catch (Exception e) {
			System.out.println(mClazz+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			return Response.error(new VolleyError(e));
		}
	}

	private String changeData(NetworkResponse response) throws UnsupportedEncodingException {


		String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers)).trim();
	/*	if (getUrl().contains("/99api/" + Utils.version + "/searchProperty/") ||getUrl().contains("/99api/" + Utils.version + "/searchProjects/")) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@_____SRP");
			json=AndroidUtils.removefirstchar(json, '[');
			json=AndroidUtils.removelastchar(json, ']');
			
		}else*/ /*if (getUrl().contains("/99api/" + Utils.version + "/refinecluster/") &&  (getUrl().contains("clusterType=Possession")|| getUrl().contains("clusterType=Building"))) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@_____1");
			json="{\"Top_Results_Array\":"+json+"}";
		}*//*else if (getUrl().contains("/getnewprojectdetail/") && getUrl().contains("?rtype=json&tab=adv")) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@_____2");
			json="{\"Top_Results_Array\":"+json+"}";
		}*//*else if (getUrl().contains("/searchdata/")) {
			json="{\"data\":"+json+"}";
		}*
		else if(getUrl().contains("/societyprojectlist/")){
			json="{\"Top_Results_Array\":"+json+"}";
		}*//*else if (getUrl().contains("/contactus/")) {
			json="{\"contact\":"+json+"}";
		}*/

       /* else if(getUrl().contains("/societyprojectlist/")){
            json="{\"Top_Results_Array\":"+json+"}";
        }*/
		System.out.println(getUrl());
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(json);
		return json;
		
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
       /* Map<String, String> headers = super.getHeaders();
        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }

        headers.put("User-Agent", "99acres android app useragent");
        headers.put("Accept-Language", "en");*/

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("User-agent", "NNACRES");


		return headers;
	}
	@Override
	public void deliverError(VolleyError error) {
        System.out.println( "Error ::" + getUrl());
        System.out.println("=================%%%%%%  "+getUrl());
        super.deliverError(error);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%% "+mClazz);
	}

}