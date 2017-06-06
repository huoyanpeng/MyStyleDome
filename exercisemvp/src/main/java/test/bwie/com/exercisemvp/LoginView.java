package test.bwie.com.exercisemvp;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */

public interface LoginView {
    //显示进度条
    void showProgressBar();
    //隐藏进度条
    void hintProgressBar();
    //用户名提交错误
    void nameEorro();
    //密码提交错误
    void passEorro();
    //登录成功
    void loginSucceed();
}
