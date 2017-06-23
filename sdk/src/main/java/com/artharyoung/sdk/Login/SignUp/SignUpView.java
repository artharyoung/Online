package com.artharyoung.sdk.Login.SignUp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.artharyoung.sdk.Login.BaseLoginView;
import com.artharyoung.sdk.Utils.ResFinder;

/**
 * Created by arthar on 2017/5/25.
 */

public class SignUpView extends BaseLoginView implements SignUpContract.View{
    private static final String TAG = "CreateAccountView";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = getActivity().getLayoutInflater().inflate(ResFinder.getId(getActivity(),"layout","online_sign_up"),container);
        ImageButton imageButton = (ImageButton)parentView.findViewById(ResFinder.getId(getActivity(),"id","online_sdk_create_new_account_back"));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "==========onClick:  back");
                dismiss();
            }
        });
        return parentView;
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {

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
