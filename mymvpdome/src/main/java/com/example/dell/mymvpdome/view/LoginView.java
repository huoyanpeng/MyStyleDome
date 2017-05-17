package com.example.dell.mymvpdome.view;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */

public interface LoginView {
    //显示进度条
    void showPrshowProgress();
    //隐藏进度条
    void hideProgress();
    //用户名输入错误
    void setUsernameError();
    //密码输入错误
    void setPasswordError();
    //登录成功
    void navigateToHome();
}
