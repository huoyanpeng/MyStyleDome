package com.example.dell.mymvpdome.presenter;

import com.example.dell.mymvpdome.model.LoginInteractor;
import com.example.dell.mymvpdome.model.LoginInteractorImpl;
import com.example.dell.mymvpdome.view.LoginView;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onUsernameError() {
         if (loginView!=null){
             loginView.setUsernameError();
             loginView.hideProgress();
         }
    }

    @Override
    public void onPasswordError() {
        if (loginView!=null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView!=null){
            loginView.navigateToHome();
        }
    }

    @Override
    public void validateCredentials(String username, String password) {

        if (loginView!=null){
            loginView.showPrshowProgress();
        }
        loginInteractor.login(username,password,this);
    }

    @Override
    public void onDestroy() {
      loginView=null;
    }
}
