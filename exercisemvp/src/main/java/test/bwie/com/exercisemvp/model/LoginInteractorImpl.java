package test.bwie.com.exercisemvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String name, final String pass, final OnLnginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error=false;
                if (TextUtils.isEmpty(name)){
                    listener.onUsernameEorro();
                    error=true;
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    listener.onUserpassEorror();
                    error=true;
                    return;
                }
                if (!error){
                    listener.onUsersucceed();
                }
            }
        },2000);
    }
}
