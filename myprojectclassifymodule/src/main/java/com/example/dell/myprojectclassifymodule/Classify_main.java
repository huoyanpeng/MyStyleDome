package com.example.dell.myprojectclassifymodule;

import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */

public interface Classify_main {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
