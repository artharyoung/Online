package com.artharyoung.sdk;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import com.artharyoung.sdk.Login.LoginManager;
import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.Pay.OnPayListener;
import com.artharyoung.sdk.Utils.ActivityLifecycle;
import com.artharyoung.sdk.Utils.GameServer;

import org.json.JSONObject;

/**
 * Created by arthar on 2017/5/25.
 */

public class SDKManager implements ActivityLifecycle, GameServer {

    private static final String TAG = "======SDKManager";
    private Context mContext = null;
    private FragmentManager mManager = null;

    /**
     * 设置成单例模式
     */
    private static class SingleSDKManager{
        private static final SDKManager instance = new SDKManager();
    }

    public static SDKManager getInstance(){
        return SingleSDKManager.instance;
    }

    @Override
    public void onActivityCreated(Activity activity) {

        mContext = activity;
        mManager = activity.getFragmentManager();
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    /**
     * 登录
     * @param onLoginListener
     */
    @Override
    public void login(OnLoginListener onLoginListener) {

        LoginManager.getInstance().start(mContext,mManager,onLoginListener);
    }

    /**
     * 支付
     * @param payInfo
     * @param onPayListener
     */
    @Override
    public void pay(String payInfo, OnPayListener onPayListener) {

    }

    /**
     * 角色信息上报，登录完成后调用
     * @param json
     */
    @Override
    public void upLoadInfo(JSONObject json) {

    }

    /**
     * 返回键调用
     */
    @Override
    public void exitApp() {

    }
}
