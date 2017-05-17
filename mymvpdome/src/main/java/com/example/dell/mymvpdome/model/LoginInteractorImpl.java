package com.example.dell.mymvpdome.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error=false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error=true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error=true;
                    return;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        },2000);
    }
}
