package com.artharyoung.sdk.Login.SignUp;

import android.app.Activity;

import com.artharyoung.sdk.Data.source.UserRepository;
import com.artharyoung.sdk.Login.OnLoginListener;

/**
 * Created by arthar on 2017/6/22.
 */

public class SignUpPresenter implements SignUpContract.Presenter {

    private static final String TAG = "SignUpPresenter";
    private SignUpContract.View mSignUpView;
    private UserRepository mUserRepository;
    private OnLoginListener mOnLoginListener;


    public SignUpPresenter(Activity activity, UserRepository userRepository,SignUpContract.View singUpView, OnLoginListener onLoginListener) {

        singUpView.setPresenter(this);
        this.mSignUpView = singUpView;
        this.mUserRepository = userRepository;
        this.mOnLoginListener = onLoginListener;
    }

    @Override
    public void start() {

    }


    @Override
    public void signUp() {
        mUserRepository.signUp(mSignUpView.getUserAccount(),mSignUpView.getPassword(),mOnLoginListener);
    }

    @Override
    public void back() {

    }
}
