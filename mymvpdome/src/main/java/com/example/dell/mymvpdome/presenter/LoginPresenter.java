package com.example.dell.mymvpdome.presenter;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);
    void onDestroy();
}
