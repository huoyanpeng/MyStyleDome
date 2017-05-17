package com.example.dell.mymvpdome.model;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */

public interface LoginInteractor {
    //内部接口
   interface OnLoginFinishedListener{
        //用户名输入错误
       void onUsernameError();
        //密码输入错误
       void onPasswordError();
        //登录成功
       void onSuccess();
   }
    //
    void login(String username,String password,OnLoginFinishedListener listener);
}
