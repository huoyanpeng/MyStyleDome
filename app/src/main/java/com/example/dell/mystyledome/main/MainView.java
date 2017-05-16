package com.example.dell.mystyledome.main;

import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/16.
 * function:
 */

public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
