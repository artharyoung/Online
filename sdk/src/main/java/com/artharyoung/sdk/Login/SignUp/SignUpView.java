package com.artharyoung.sdk.Login.SignUp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.artharyoung.sdk.Login.BaseLoginView;
import com.artharyoung.sdk.Utils.Util;

/**
 * Created by arthar on 2017/5/25.
 */

public class SignUpView extends BaseLoginView implements SignUpContract.View{
    private static final String TAG = "CreateAccountView";

    private SignUpContract.Presenter mPresenter;
    private AutoCompleteTextView mAccountText;
    private EditText mPasswordText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = getActivity().getLayoutInflater().inflate(Util.getId(getActivity(),"layout","online_sign_up"),container);

        mAccountText = (AutoCompleteTextView)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_create_account"));
        mPasswordText = (EditText)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_create_password"));

        ImageButton imageButton = (ImageButton)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_create_new_account_back"));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "==========onClick:  back");
                dismiss();
                mPresenter.back(getActivity());
            }
        });

        Button signButton = (Button)parentView.findViewById(Util.getId(getActivity(),"id","online_sdk_create_new_account_button"));
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.signUp();
            }
        });
        return parentView;
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public String getUserAccount() {
        return mAccountText.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordText.getText().toString();
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
    public void toMainAct() {

    }

    @Override
    public void showFailedError() {

    }

}
