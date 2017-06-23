package com.artharyoung.sdk.Login.LogIn;

import android.app.Activity;

import com.artharyoung.sdk.Utils.BasePresenter;
import com.artharyoung.sdk.Utils.BaseView;

/**
 * Created by arthar on 2017/5/31.
 */

public class LoginContract {

    interface Presenter extends BasePresenter {

        void signIn();

        void createAnAccount(Activity activity);

        void forgottenYourPassword(Activity activity);
    }

    interface View extends BaseView<Presenter> {
        String getUserAccount();

        String getPassword();

        boolean isAccountValid(String account);

        boolean isPasswordValid(String password);

        boolean setAccountError(String error);

        boolean setPasswordError(String error);

        void showLoginProgress(boolean show);

        void resetEditView();

        void toMainAct();

        void showFailedError();
    }
}
