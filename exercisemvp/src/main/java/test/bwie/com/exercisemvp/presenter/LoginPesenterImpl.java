package test.bwie.com.exercisemvp.presenter;

import test.bwie.com.exercisemvp.LoginView;
import test.bwie.com.exercisemvp.model.LoginInteractor;
import test.bwie.com.exercisemvp.model.LoginInteractorImpl;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */
public class LoginPesenterImpl implements loginPesenter,LoginInteractor.OnLnginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPesenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }
    @Override
    public void onUsernameEorro() {
        if (loginView!=null){
            loginView.nameEorro();
            loginView.hintProgressBar();
        }
    }

    @Override
    public void onUserpassEorror() {
        if (loginView!=null){
            loginView.passEorro();
            loginView.hintProgressBar();
        }
    }

    @Override
    public void onUsersucceed() {
           if (loginView!=null){
               loginView.loginSucceed();
               loginView.hintProgressBar();
           }
    }

    @Override
    public void validateCredentials(String name, String pass) {
        if (loginView!=null){
            loginView.showProgressBar();
        }
        loginInteractor.login(name,pass,this);
    }

    @Override
    public void onDestroy() {

    }
}
