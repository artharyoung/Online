package com.artharyoung.sdk;

import android.app.Activity;

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
    public void login(Activity activity, OnLoginListener onLoginListener) {

        LoginManager.getInstance().start(activity,onLoginListener);
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
