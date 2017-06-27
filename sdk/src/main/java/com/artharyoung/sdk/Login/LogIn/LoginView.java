package com.artharyoung.sdk.Login.LogIn;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artharyoung.sdk.Login.BaseLoginView;
import com.artharyoung.sdk.Utils.Util;

/**
 * Created by arthar on 2017/5/25.
 */

public class LoginView extends BaseLoginView implements LoginContract.View {

    private static final String TAG = "LoginView";

    private LoginContract.Presenter mPresenter;
    private EditText mAccount = null;
    private EditText mPassword = null;
    private TextView mForgottenPassword = null;
    private TextView mCreateAccount = null;
    private Button mSignInButton = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "===onCreateView: 切换横竖屏");

        /**
         *
         * 只能这么写才能使用support包的特性，即输入框变为下划线
         */
        View parentView = getActivity().getLayoutInflater().inflate(Util.getId(getActivity(),"layout","online_login_main"),container);
        mForgottenPassword = (TextView) parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_password_forgotten"));
        mCreateAccount = (TextView) parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_account_create"));
        mForgottenPassword.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG|Paint.UNDERLINE_TEXT_FLAG);//设置下划线并抗锯齿（防止锯齿）
        mCreateAccount.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG|Paint.UNDERLINE_TEXT_FLAG);
        mForgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.forgottenYourPassword(getActivity());
                dismiss();
            }
        });

        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.createAnAccount(getActivity());
                dismiss();
            }
        });

        mAccount = (EditText)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_account"));
        mPassword = (EditText)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_password"));
        mSignInButton = (Button)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_sign_in_button"));
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.signIn();
            }
        });

        return parentView;
    }



    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public String getUserAccount() {
        return mAccount.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
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
