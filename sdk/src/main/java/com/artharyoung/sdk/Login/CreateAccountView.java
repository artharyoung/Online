package com.artharyoung.sdk.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artharyoung.sdk.Utils.ResFinder;

/**
 * Created by arthar on 2017/5/25.
 */

public class CreateAccountView extends BaseLoginView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView = getActivity().getLayoutInflater().inflate(ResFinder.getId(getActivity(),"layout","online_create_new_account"),container);

        return parentView;
    }
}
