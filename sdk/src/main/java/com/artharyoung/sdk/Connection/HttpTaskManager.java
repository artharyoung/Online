package com.artharyoung.sdk.Connection;


import android.os.AsyncTask;
import android.util.Log;

import com.artharyoung.sdk.Login.OnLoginListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by arthar on 2017/5/25.
 */

public class HttpTaskManager {

    private static final String TAG = "HttpTaskManager";

    private static class SingleHttpTaskManager{
        private static final HttpTaskManager instance = new HttpTaskManager();
    }

    public static HttpTaskManager getInstance(){
        return SingleHttpTaskManager.instance;
    }

    public void login(final OnLoginListener onLoginListener){
        new LoginRequest(new DataCallBack() {
            @Override
            public void onSuccess(String st) {
                Log.d(TAG, "======onSuccess: " + st);
                onLoginListener.onSuccess(new JSONObject());
            }

            @Override
            public void onError(String st) {

            }
        }).execute("http://ip.taobao.com/service/getIpInfo.php?ip=58.251.17.238");
    }


    public interface DataCallBack{
        void onSuccess(String st);
        void onError(String st);
    }

    public class LoginRequest extends AsyncTask<String,Integer,String>{

        private DataCallBack mDataCallBack;

        public LoginRequest(DataCallBack dataCallBack){

            mDataCallBack = dataCallBack;
        }

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            HttpURLConnection connection = null;
            InputStream inStream = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(false);//post请求需要向HttpsURLConnection输出，默认false
                connection.setUseCaches(false);//不使用缓存
                connection.setRequestProperty("Content-type", "application/json");//设置文本类型
                connection.setRequestMethod("GET");//设置请求类型
                connection.setConnectTimeout(5000);//连接超时 单位毫秒
                connection.setReadTimeout(5000);//读取超时 单位毫秒
                connection.setRequestProperty("User-Agent",
                   "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
                connection.setRequestProperty("Connection", "Keep-Alive"); // 设置为持久连接
                connection.connect();
                int resultCode = connection.getResponseCode();
                if(resultCode == HttpURLConnection.HTTP_OK){

                    inStream = connection.getInputStream();
                    result = inputStreamToString(inStream);
                }else{
                    Log.d("ZZY", "doInBackground:resultCode= " + resultCode);
                    mDataCallBack.onError("" + resultCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(inStream != null){
                    try {
                        inStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(connection != null){
                    connection.disconnect();
                }
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            mDataCallBack.onSuccess(result);
        }
    }

    public static String inputStreamToString(InputStream in) {

        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuffer sb = new StringBuffer();

            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
