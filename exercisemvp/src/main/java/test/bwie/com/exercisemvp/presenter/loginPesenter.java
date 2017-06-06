package test.bwie.com.exercisemvp.presenter;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */

public interface loginPesenter {
    void validateCredentials(String name,String pass);
    void onDestroy();
}
