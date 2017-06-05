package com.artharyoung.sdk.Login;

import android.app.Activity;
import android.util.Log;

import com.artharyoung.sdk.Data.source.UserRepository;

/**
 * Created by arthar on 2017/5/31.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private static final String TAG = "LoginPresenter";

    private LoginContract.View mLoginView = null;
    private OnLoginListener mOnLoginListener = null;
    private UserRepository mRepository = null;

    public LoginPresenter(Activity activity, UserRepository userRepository, LoginContract.View loginView, OnLoginListener onLoginListener){

        loginView.setPresenter(this);

        this.mLoginView = loginView;
        this.mOnLoginListener = onLoginListener;
        this.mRepository = userRepository;
    }

    @Override
    public void start() {
        Log.d(TAG, "start: 显示");
        //这个回调所要完成的任务并不明确，甚至这个接口存在的意义都不明显
    }

    @Override
    public void signIn() {
        Log.d(TAG, "=========signIn: " + mLoginView.getUserAccount());
        Log.d(TAG, "=========signIn: " + mLoginView.getPassword());
        mRepository.login(mLoginView.getUserAccount(),mLoginView.getPassword(),mOnLoginListener);
    }

    @Override
    public void createAnAccount(Activity activity) {
        Log.d(TAG, "createAnAccount: 跳转到注册");
        CreateAccountView createAccountView = new CreateAccountView();
        createAccountView.show(activity.getFragmentManager(),CreateAccountView.class.getName());
    }

    @Override
    public void forgottenYourPassword(Activity activity) {
        Log.d(TAG, "forgottenYourPassword: 找回密码");

    }
}