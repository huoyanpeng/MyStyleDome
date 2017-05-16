package com.example.dell.mystyledome.Login;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/16.
 * function:
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);


}
