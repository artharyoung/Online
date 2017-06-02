package com.artharyoung.sdk.Login;

import android.app.Activity;
import android.util.Log;

import com.artharyoung.sdk.Data.source.UserRepository;
import com.artharyoung.sdk.Data.source.remote.HttpTaskManager;

/**
 * Created by arthar on 2017/5/31.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private static final String TAG = "LoginPresenter";

    private LoginContract.View mLoginView = null;
    private OnLoginListener mOnLoginListener = null;

    public LoginPresenter(Activity activity, UserRepository userRepository, LoginContract.View loginView, OnLoginListener onLoginListener){

        loginView.setPresenter(this);

        this.mLoginView = loginView;
        this.mOnLoginListener = onLoginListener;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: 显示");
    }

    @Override
    public void signIn() {
        Log.d(TAG, "=========signIn: " + mLoginView.getUserAccount());
        Log.d(TAG, "=========signIn: " + mLoginView.getPassword());
        HttpTaskManager.getInstance().login(mOnLoginListener);
    }

    @Override
    public void createAnAccount() {
        Log.d(TAG, "createAnAccount: 跳转到注册");
    }

    @Override
    public void forgottenYourPassword() {
        Log.d(TAG, "forgottenYourPassword: 找回密码");
    }
}