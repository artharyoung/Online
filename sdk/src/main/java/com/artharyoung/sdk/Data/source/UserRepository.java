package com.artharyoung.sdk.Data.source;

import android.util.Log;

import com.artharyoung.sdk.Data.source.remote.HttpTaskManager;
import com.artharyoung.sdk.Login.OnLoginListener;

/**
 * Created by arthar on 2017/6/2.
 * 这一层作为用户信息的总出口，所有用户相关都通过这个类交互
 * 做数据的持久化存储。
 * 数据加密也放在这一层
 */

public class UserRepository {

    private static final String TAG = "UserRepository";

    /**
     * 通过账号密码登录
     * @param account
     * @param password
     * @param onLoginListener
     */
    public void login(String account, String password, OnLoginListener onLoginListener){
        Log.d(TAG, "login: " + account + "|" + password);
        HttpTaskManager.getInstance().login(account,password,onLoginListener);
    }

    /**
     * 通过缓存的token登录
     * @param token
     * @param onLoginListener
     */
    public void login(String token, OnLoginListener onLoginListener){
        HttpTaskManager.getInstance().login(token,onLoginListener);
    }
}
