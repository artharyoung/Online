package com.artharyoung.sdk.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artharyoung.sdk.Utils.ResFinder;

/**
 * Created by arthar on 2017/5/25.
 */

public class LoginView extends BaseLoginView implements LoginContract.View{
    private static final String TAG = "LoginView";

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(ResFinder.getId(getActivity(),"layout","online_login_main"),null);

        return parent;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public String getUserAccount() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountValid(String account) {
        return false;
    }

    @Override
    public boolean isPasswordValid(String password) {
        return false;
    }

    @Override
    public boolean setAccountError(String error) {
        return false;
    }

    @Override
    public boolean setPasswordError(String error) {
        return false;
    }

    @Override
    public void showLoginProgress(boolean show) {

    }

    @Override
    public void resetEditView() {

    }

    @Override
    public void toMainAct() {

    }

    @Override
    public void showFailedError() {

    }
}
