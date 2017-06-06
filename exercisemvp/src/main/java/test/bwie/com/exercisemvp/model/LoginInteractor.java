package test.bwie.com.exercisemvp.model;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */

public interface LoginInteractor {
    //内部接口
    interface OnLnginFinishedListener{
        //用户名输入错误
        void onUsernameEorro();
        //密码输入错误
        void onUserpassEorror();
        //登录成功
        void onUsersucceed();
    };
    void login(String name,String pass,OnLnginFinishedListener listener);
}
