package com.artharyoung.sdk.Login;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;

import com.artharyoung.sdk.Data.source.remote.HttpTaskManager;

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

        LoginView loginView = new LoginView();
        loginView.show(manager,loginView.getClass().getName());

        HttpTaskManager.getInstance().login(onLoginListener);
    }
}