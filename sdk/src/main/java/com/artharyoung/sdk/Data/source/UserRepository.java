package com.artharyoung.sdk.Data.source;

import android.util.Log;

import com.artharyoung.sdk.Data.source.remote.HttpTaskManager;
import com.artharyoung.sdk.Login.OnLoginListener;

/**
 * Created by arthar on 2017/6/2.
 * 这一层作为用户信息的总出口，所有用户相关都通过这个类交互
 * 做数据的持久化存储。
 * 数据加密也放在这一层
 * 数据的存储，加密以及登录时的交互
 */

public class UserRepository {

    private static final String TAG = "UserRepository";
    private static final class SingleUserRepository{
        private static final UserRepository userRepository = new UserRepository();
    }

    public static UserRepository getInstance(){
        return SingleUserRepository.userRepository;
    }

    /**
     * 通过账号密码登录
     *
     * @param account
     * @param password
     * @param onLoginListener
     */
    public void login(String account, String password, OnLoginListener onLoginListener) {
        Log.d(TAG, "login: " + account + "|" + password);
        HttpTaskManager.getInstance().login(account, password, onLoginListener);
    }

    /**
     * 通过缓存的token登录
     *
     * @param token
     * @param onLoginListener
     */
    public void login(String token, OnLoginListener onLoginListener) {
        HttpTaskManager.getInstance().login(token, onLoginListener);
    }

    /**
     * 通过账号与密码进行注册。发起请求后可能存在以下几种情况：
     * 1、账号已存在，返回一条提示信息。
     * 2、网络错误，或链接网络失败。
     * 3、账号注册成功，返回一个登录的token，然后自动登录
     * 除此之外，在登录之前，应进行账号长短，以及特殊字符的正则表达式判断。这部分全部放在本地处理。
     * @param account
     * @param password
     * @param onLoginListener
     */
    public void signUp(String account, String password, OnLoginListener onLoginListener) {
        HttpTaskManager.getInstance().singUp(account, password, onLoginListener);
    }
}
