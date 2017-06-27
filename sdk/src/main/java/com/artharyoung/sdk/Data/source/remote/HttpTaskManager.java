package com.artharyoung.sdk.Data.source.remote;


import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.artharyoung.sdk.Data.bean.Iptestbhean;
import com.artharyoung.sdk.Login.OnLoginListener;
import com.google.gson.Gson;

/**
 * Created by arthar on 2017/5/25.
 */

public class HttpTaskManager {

    /**
     * test
     */

    private String getTestUrl() {
        return "http://ip.taobao.com/service/getIpInfo.php?ip=" + randomInt(0, 255) + "." + randomInt(0, 255) + "." + randomInt(0, 255) + "." + randomInt(0, 255);
    }

    private static int randomInt(int start, int end) {
        int rtnn = Long.valueOf(start + (long) (Math.random() * (end - start))).intValue();
        if (rtnn == start || rtnn == end) {
            return randomInt(start, end);
        }
        return rtnn;
    }

    /**
     * ===================以上均为测试===========================
     */
    private static final String TAG = "HttpTaskManager";
    private static RequestQueue mQueue = null;


    private static class SingleHttpTaskManager {
        private static final HttpTaskManager instance = new HttpTaskManager();
    }

    public static HttpTaskManager getInstance() {
        return SingleHttpTaskManager.instance;
    }

    public void init(Activity activity) {
        mQueue = Volley.newRequestQueue(activity);
    }

    private RequestQueue getQueue() {
        if (mQueue == null) {
            throw new NullPointerException(TAG + " has not be init");
        }
        return mQueue;
    }

    /**
     * 通过账号，密码登录
     *
     * @param account
     * @param password
     * @param onLoginListener
     */
    public void login(String account, String password, final OnLoginListener onLoginListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + response);

                Gson gson = new Gson();
                Iptestbhean iptestbhean = gson.fromJson(response, Iptestbhean.class);
                if (iptestbhean.getData().getCountry_id().equals("US")) {
                    onLoginListener.onSuccess(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                } else {
                    onLoginListener.onFailure(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        getQueue().add(stringRequest);
    }

    /**
     * 通过token登录
     *
     * @param token
     * @param onLoginListener
     */
    public void login(String token, final OnLoginListener onLoginListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + response);

                Gson gson = new Gson();
                Iptestbhean iptestbhean = gson.fromJson(response, Iptestbhean.class);
                if (iptestbhean.getData().getCountry_id().equals("US")) {
                    onLoginListener.onSuccess(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                } else {
                    onLoginListener.onFailure(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.networkResponse.statusCode);
                Log.d(TAG, "onErrorResponse: " + error.getNetworkTimeMs());
                Log.d(TAG, "onErrorResponse: " + error.networkResponse.data.length);
            }
        });

        getQueue().add(stringRequest);
    }


    public void singUp(String account, String password, final OnLoginListener onLoginListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + response);

                Gson gson = new Gson();
                Iptestbhean iptestbhean = gson.fromJson(response, Iptestbhean.class);
                if (iptestbhean.getData().getCountry_id().equals("US")) {
                    onLoginListener.onSuccess(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                } else {
                    onLoginListener.onFailure(String.valueOf(iptestbhean.getCode()), iptestbhean.getData().getCountry());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.networkResponse.statusCode);
                Log.d(TAG, "onErrorResponse: " + error.getNetworkTimeMs());
                Log.d(TAG, "onErrorResponse: " + error.networkResponse.data.length);
            }
        });

        getQueue().add(stringRequest);
    }
}
