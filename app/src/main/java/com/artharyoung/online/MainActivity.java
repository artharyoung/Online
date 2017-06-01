package com.artharyoung.online;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.SDKManager;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "============模拟的游戏内部接口：";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SDKManager.getInstance().onActivityCreated(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SDKManager.getInstance().onActivityStarted(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SDKManager.getInstance().onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SDKManager.getInstance().onActivityPaused(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SDKManager.getInstance().onActivityStopped(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SDKManager.getInstance().onActivityDestroyed(this);
    }

    public void onLogin(View view){
        Log.d(TAG, "onLogin: 启动！");
        SDKManager.getInstance().login(this,new OnLoginListener() {

            @Override
            public void onSuccess(JSONObject json) {
                Log.d(TAG, "onSuccess: 登录成功了！");
            }

            @Override
            public void onFailure(JSONObject json) {
                Log.d(TAG, "onFailure: 登录失败了！");
            }
        });
    }

    public void onDisplay(View view){
        Log.d(TAG, "onDisplay: ");
    }

    public void onHide(View view){
        Log.d(TAG, "onHide: ");


    }

    public void onUpload(View view){
        Log.d(TAG, "onUpload: ");
        SDKManager.getInstance().upLoadInfo(new JSONObject());
    }

    public void onPay(View view){
        Log.d(TAG, "onPay: ");

    }

    public void onExit(View view){
        Log.d(TAG, "onExit: ");
    }




}
