package com.artharyoung.sdk.Login.SignUp;

import com.artharyoung.sdk.Utils.BasePresenter;
import com.artharyoung.sdk.Utils.BaseView;

/**
 * Created by arthar on 2017/6/22.
 */

public class SignUpContract {
    interface Presenter extends BasePresenter {

        void signUp();

        void back();
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
