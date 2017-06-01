package com.artharyoung.sdk.Login;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artharyoung.sdk.Utils.ResFinder;

/**
 * Created by arthar on 2017/5/25.
 */

public class LoginView extends BaseLoginView implements LoginContract.View{

    private static final String TAG = "LoginView";

    private LoginContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 只能这么写才能使用support包的特性，即输入框变为下划线
         */
        View parentView = getActivity().getLayoutInflater().inflate(ResFinder.getId(getActivity(),"layout","online_login_main"),container);
        TextView forgottenPassword = (TextView) parentView.findViewById(ResFinder.getId(getActivity(),"id","online_sdk_password_forgotten"));
        TextView createAccount = (TextView) parentView.findViewById(ResFinder.getId(getActivity(),"id","online_sdk_account_create"));
        forgottenPassword.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG|Paint.UNDERLINE_TEXT_FLAG);//设置下划线并抗锯齿（防止锯齿）
        createAccount.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG|Paint.UNDERLINE_TEXT_FLAG);

        return parentView;
    }

    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.start();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
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
