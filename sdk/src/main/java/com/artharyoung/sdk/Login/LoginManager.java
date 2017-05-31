package com.artharyoung.sdk.Login;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;

import com.artharyoung.sdk.Connection.HttpTaskManager;

/**
 * Created by arthar on 2017/5/25.
 */

public class LoginManager {

    private static class SingleLoginManager{
        private static final LoginManager instance = new LoginManager();
    }

    public static LoginManager getInstance(){
        return SingleLoginManager.instance;
    }

    public void start(@NonNull Context context, @NonNull FragmentManager manager, @NonNull OnLoginListener onLoginListener){

        HttpTaskManager.getInstance().login(onLoginListener);
        LoginView loginView = new LoginView();
        loginView.show(manager,"a");
    }
}