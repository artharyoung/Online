package com.artharyoung.online;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.SDKManager;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    /**
     *
     */
    private static final String TAG = "============模拟的游戏内部接口：";
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

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
            public void onSuccess(String statue,String token) {

                Toast.makeText(mContext,"大概也许应该是成功了！登录地是" + token,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String statue,String msg) {

                Toast.makeText(mContext,"跑错地儿了！登录地是" + msg,Toast.LENGTH_LONG).show();
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
        SDKManager.getInstance().exitApp(this);
    }


    @Override
    public void onBackPressed() {
        SDKManager.getInstance().exitApp(this);
        Handler handler = new MyHandler(this);

    }

    private static class MyHandler extends Handler {
            private WeakReference<Activity> activityWeakReference;

            public MyHandler(Activity activity) {
                activityWeakReference = new WeakReference<Activity>(activity);
            }

            @Override
            public void handleMessage(Message msg) {
                Activity activity = activityWeakReference.get();
                if (activity != null) {

                }
            }
        }
}
