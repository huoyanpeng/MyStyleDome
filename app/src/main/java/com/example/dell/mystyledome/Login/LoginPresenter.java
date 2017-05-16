package com.example.dell.mystyledome.Login;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/16.
 * function:
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
