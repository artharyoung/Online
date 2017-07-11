package com.artharyoung.sdk.Data.source.remote;


import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.artharyoung.sdk.Data.bean.IpTestFirst;
import com.artharyoung.sdk.Data.bean.Iptestbhean;
import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.Utils.Util;

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

        Log.d(TAG, "login: account: " + account + "|" + "password:" + password);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + getTestUrl());
                Log.d(TAG, "====onResponse: " + response );

                IpTestFirst ipTestFirst = Util.getBeanFromJson(response, IpTestFirst.class);
                if(ipTestFirst.getCode() == 0){
                    Iptestbhean js = Util.getBeanFromJson(ipTestFirst.getData(), Iptestbhean.class);
                    onLoginListener.onSuccess(String.valueOf(ipTestFirst.getCode()), js.getCountry());
                }else {
                    onLoginListener.onFailure(String.valueOf(ipTestFirst.getCode()), "没有返回数据！");
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

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + response);

                IpTestFirst ipTestFirst = Util.getBeanFromJson(response, IpTestFirst.class);
                if(ipTestFirst.getCode() == 0){
                    Iptestbhean js = Util.getBeanFromJson(ipTestFirst.getData(), Iptestbhean.class);
                    onLoginListener.onSuccess(String.valueOf(ipTestFirst.getCode()), js.getCountry());
                }else {
                    onLoginListener.onFailure(String.valueOf(ipTestFirst.getCode()), "没有返回数据！");
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

    /**
     * 注册成功后出发登录，切换登录状态。
     * @param account
     * @param password
     * @param onLoginListener
     */
    public void singUp(String account, String password, final OnLoginListener onLoginListener) {
        Log.d(TAG, "login: account: " + account + "|" + "password:" + password);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getTestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d(TAG, "====onResponse: " + response);

                IpTestFirst ipTestFirst = Util.getBeanFromJson(response, IpTestFirst.class);
                if(ipTestFirst.getCode() == 0){
                    Iptestbhean js = Util.getBeanFromJson(ipTestFirst.getData(), Iptestbhean.class);
                    onLoginListener.onSuccess(String.valueOf(ipTestFirst.getCode()), js.getCountry());
                }else {
                    onLoginListener.onFailure(String.valueOf(ipTestFirst.getCode()), "请求虽然成功了，没有返回数据！");
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

        stringRequest.setTag("Test");
        getQueue().add(stringRequest);
//        getQueue().cancelAll("Test");


        ImageRequest imageRequest = new ImageRequest(getTestUrl(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

            }
        }, 1280, 720, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

//        ImageLoader imageLoader = new ImageLoader(getQueue(),new BitmapCache());
//        ImageLoader.ImageListener listener = ImageLoader.getImageListener(new ImageView(), R.drawable.online_sdk_back,R.drawable.online_sdk_back);
//        imageLoader.get(getTestUrl(),listener);

    }

    class BitmapCache implements ImageLoader.ImageCache{

        private LruCache<String,Bitmap> mLruCache;
        public BitmapCache(){
            int maxSize = 10 * 1024 * 1024;
            mLruCache = new LruCache<String,Bitmap>(maxSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mLruCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mLruCache.put(url,bitmap);
        }
    }

    private void VolleyImageLoader(NetworkImageView mNetworkView) {
        String mPicUrl = "http://t1.du114.com/uploads/tu/201510/fengjing/rgj5thjkwlf.jpg";
        ImageLoader imgLoader = new ImageLoader(getQueue(),new BitmapCache());
        mNetworkView.setDefaultImageResId(android.R.drawable.ic_menu_rotate);
        mNetworkView.setErrorImageResId(android.R.drawable.ic_delete);
        mNetworkView.setImageUrl(mPicUrl,imgLoader);
    }
}
