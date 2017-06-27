package com.artharyoung.sdk.Login;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.artharyoung.sdk.Data.source.UserRepository;
import com.artharyoung.sdk.Login.LogIn.LoginPresenter;
import com.artharyoung.sdk.Login.LogIn.LoginView;
import com.artharyoung.sdk.Login.SignUp.SignUpPresenter;
import com.artharyoung.sdk.Login.SignUp.SignUpView;

/**
 * Created by arthar on 2017/5/25.
 * 在这一层，负责处理两种情况：
 * 1、已经登录过，存储了token，则用token登录，显示正在登录的界面，并可以切换账号s
 * 2、没有登录记录，显示登录界面。该界面可操作的逻辑包括登录、找回密码、注册新帐号。完成这些操作后切换至登录过场动画
 */

public class LoginManager {

    private static final String TAG = "LoginManager";
    private static class SingleLoginManager{
        private static final LoginManager instance = new LoginManager();
    }

    public static LoginManager getInstance(){
        return SingleLoginManager.instance;
    }

    public void start(@NonNull Activity activity, @NonNull OnLoginListener onLoginListener){

        LoginView loginView = new LoginView();
        new LoginPresenter(activity,UserRepository.getInstance(),loginView,onLoginListener);
        loginView.show(activity.getFragmentManager(),loginView.getClass().getName());
    }

    public void signUp(@NonNull Activity activity, @NonNull OnLoginListener onLoginListener){

        SignUpView createAccountView = new SignUpView();
        new SignUpPresenter(activity,UserRepository.getInstance(), createAccountView,onLoginListener);
        createAccountView.show(activity.getFragmentManager(),SignUpView.class.getName());
    }

    public void findPassword(@NonNull Activity activity, @NonNull OnLoginListener onLoginListener){

    }
}