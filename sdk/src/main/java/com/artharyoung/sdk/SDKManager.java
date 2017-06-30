package com.artharyoung.sdk;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.artharyoung.sdk.Data.source.remote.HttpTaskManager;
import com.artharyoung.sdk.Login.LoginManager;
import com.artharyoung.sdk.Login.OnLoginListener;
import com.artharyoung.sdk.Pay.OnPayListener;
import com.artharyoung.sdk.Utils.ActivityLifecycle;
import com.artharyoung.sdk.Utils.GameServer;
import com.artharyoung.sdk.Utils.Util;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

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
        //初始化网络请求服务
        HttpTaskManager.getInstance().init(activity);

        /**
         * 游戏参数以配置文件的形式放在assets目录下。在实际的对接过程中，有遇到过因为复制粘贴在manifest里面或者其他地方
         * 读取时产生转移字符的问题导致不能使用到正确的参数。放在一个文件里主要是便于保证参数的完整性。同时，这个配置文件也可以用来
         * 配置渠道区分的参数。
         */
        try {
            InputStream inputStream = activity.getResources().getAssets().open("online_configuration.json");
            String config = Util.inputStreamToString(inputStream);
            Log.d(TAG, "====onActivityCreated: " + Util.md5(config) +"|" + Util.getUniquePsuedoID());
            Log.d(TAG, "====onActivityCreated: ");
            //31f50f803cce1d200574a055adafb3d8
        } catch (IOException e) {
            Toast.makeText(activity,activity.getString(Util.getId(activity,"string","online_sdk_config_file")),Toast.LENGTH_LONG).show();
            activity.finish();//无配置文件无法调试
        }
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
        Log.d(TAG, "========exitApp: 返回键");
    }
}
